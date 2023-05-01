package com.zelyder.recyclemap.presentation.ui.map

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.Color
import android.webkit.WebView
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import com.mapbox.android.gestures.MoveGestureDetector
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.MapView
import com.mapbox.maps.Style
import com.mapbox.maps.dsl.cameraOptions
import com.mapbox.maps.extension.style.expressions.dsl.generated.format
import com.mapbox.maps.extension.style.expressions.dsl.generated.has
import com.mapbox.maps.extension.style.expressions.dsl.generated.step
import com.mapbox.maps.extension.style.expressions.generated.Expression
import com.mapbox.maps.extension.style.layers.addLayer
import com.mapbox.maps.extension.style.layers.generated.circleLayer
import com.mapbox.maps.extension.style.layers.generated.symbolLayer
import com.mapbox.maps.extension.style.layers.properties.generated.ProjectionName
import com.mapbox.maps.extension.style.projection.generated.projection
import com.mapbox.maps.extension.style.sources.addSource
import com.mapbox.maps.extension.style.sources.generated.geoJsonSource
import com.mapbox.maps.extension.style.types.transitionOptions
import com.mapbox.maps.extension.style.utils.ColorUtils
import com.mapbox.maps.plugin.animation.MapAnimationOptions
import com.mapbox.maps.plugin.animation.flyTo
import com.mapbox.maps.plugin.annotation.annotations
import com.mapbox.maps.plugin.annotation.generated.*
import com.mapbox.maps.plugin.gestures.OnMoveListener
import com.mapbox.maps.plugin.gestures.gestures
import com.mapbox.maps.plugin.locationcomponent.OnIndicatorBearingChangedListener
import com.mapbox.maps.plugin.locationcomponent.OnIndicatorPositionChangedListener
import com.mapbox.maps.plugin.locationcomponent.location
import com.zelyder.recyclemap.R
import kotlinx.coroutines.*


object  MyMap {

    lateinit var mapView: MapView
    private const val GEOJSON_SOURCE_ID = "earthquakes"
    private const val CROSS_ICON_ID = "cross-icon-id"
    private val scope = CoroutineScope(Dispatchers.Main)
        @Composable
        fun MapScreen() {
            AndroidView(factory = { context ->
                mapView = MapView(context)
                mapView.apply {
                    getMapboxMap().loadStyleUri(Style.MAPBOX_STREETS) {
                        addClusteredGeoJsonSource(it)
                        flyToPosition()
                    }
                    transitionOptions {  }
                    projection(ProjectionName.GLOBE)
                    cameraOptions {
                        zoom(14.0)
                    }

                }
            })

        }

    @SuppressLint("SetJavaScriptEnabled")
    @Composable
    fun MapWebScreen() {
        val state = rememberWebViewState(url = "https://recyclemap.ru/")
        var web: WebView?
        WebView(
            modifier = Modifier.fillMaxSize(),
            state = state,
            onCreated = {
                it.settings.javaScriptEnabled = true
                web = it
                scope.launch {
                    delay(3500L)
                        web?.loadUrl("javascript:(function(){document.getElementsByClassName('point_controll')[0].remove();})()")
                        web?.loadUrl("javascript:(function(){document.getElementById('head').remove();})()")
                        web?.loadUrl("javascript:(function(){document.getElementById('map').style.top = '0px';})()")
                        web?.loadUrl("javascript:(function(){document.getElementsByClassName('mapboxgl-canvas')[0].style.height = '670px'})()")
                }
            }
        )
    }
        private val points = listOf(
            Pair(37.236489, 55.997487),
            Pair(37.233776, 56.000985),
            Pair(37.216942, 55.996213),
            Pair(37.236489, 55.997487),
            Pair(37.215891, 55.996983),
            Pair(37.211490, 56.001593),
        )

        private fun addPoint(
            longitude: Double, latitude: Double, pointerAnnotationManager: CircleAnnotationManager
        ) {
            val circleAnnotationOptions =
                CircleAnnotationOptions().withPoint(Point.fromLngLat(longitude, latitude))
                    .withCircleRadius(8.0).withCircleColor("#32CD32").withCircleStrokeWidth(2.0)
                    .withCircleStrokeColor("#ffffff")

            pointerAnnotationManager.create(circleAnnotationOptions)
        }

    private fun addCustomAnnotation(point: Point, bitmap: Bitmap) {
        val annotationApi = mapView.annotations
        val pointAnnotationManager = annotationApi.createPointAnnotationManager()

        val pointAnimationOptions = PointAnnotationOptions()
            .withPoint(point)
            .withIconImage(bitmap)

        pointAnnotationManager.create(pointAnimationOptions)

    }

    private fun addClusteredGeoJsonSource(style: Style) {

        // Add a new source from the GeoJSON data and set the 'cluster' option to true.
        style.addSource(
            // Point to GeoJSON data. This example visualizes all M1.0+ earthquakes from 12/22/15 to 1/21/16 as logged by USGS' Earthquake hazards program.
            geoJsonSource(GEOJSON_SOURCE_ID) {
                url("https://www.mapbox.com/mapbox-gl-js/assets/earthquakes.geojson")
                cluster(true)
                maxzoom(14)
                clusterRadius(50)
            }
        )

        // Creating a marker layer for single data points
        style.addLayer(
            symbolLayer("unclustered-points", GEOJSON_SOURCE_ID) {
                iconImage(CROSS_ICON_ID)
                iconSize(
                    Expression.division {
                        get {
                            literal("mag")
                        }
                        literal(4.0)
                    }
                )
                iconColor(
                    Expression.interpolate {
                        exponential {
                            literal(1)
                        }
                        get {
                            literal("mag")
                        }
                        stop {
                            literal(2.0)
                            rgb {
                                literal(0)
                                literal(255)
                                literal(0)
                            }
                        }
                        stop {
                            literal(4.5)
                            rgb {
                                literal(0)
                                literal(0)
                                literal(255)
                            }
                        }
                        stop {
                            literal(7.0)
                            rgb {
                                literal(255)
                                literal(0)
                                literal(0)
                            }
                        }
                    }
                )
                filter(
                    has {
                        literal("mag")
                    }
                )
            }
        )

        // Use the earthquakes GeoJSON source to create three layers: One layer for each cluster category.
        // Each point range gets a different fill color.
        val layers = arrayOf(
            intArrayOf(150, ContextCompat.getColor(mapView.context, R.color.purple_200)),
            intArrayOf(20, ContextCompat.getColor(mapView.context, R.color.teal_200)),
            intArrayOf(0, ContextCompat.getColor(mapView.context, R.color.black))
        )

        // Add clusters' circles
        style.addLayer(
            circleLayer("clusters", GEOJSON_SOURCE_ID) {
                circleColor(
                    step {
                        get("point_count")
                        literal(ColorUtils.colorToRgbaString(layers[2][1]))
                        stop {
                            literal(layers[1][0].toDouble())
                            literal(ColorUtils.colorToRgbaString(layers[1][1]))
                        }
                        stop {
                            literal(layers[0][0].toDouble())
                            literal(ColorUtils.colorToRgbaString(layers[0][1]))
                        }
                    }
                )
                circleRadius(18.0)
                filter(
                    has("point_count")
                )
            }
        )

        style.addLayer(
            symbolLayer("count", GEOJSON_SOURCE_ID) {
                textField(
                    format {
                        formatSection(
                            com.mapbox.maps.extension.style.expressions.dsl.generated.toString {
                                get {
                                    literal("point_count")
                                }
                            }
                        )
                    }
                )
                textSize(12.0)
                textColor(Color.WHITE)
                textIgnorePlacement(true)
                textAllowOverlap(true)
            }
        )
    }
    private fun flyToPosition() {
        val point = points.first()
        val cameraCenterCoordinates = Point.fromLngLat(point.first, point.second)

        val cameraOptions = CameraOptions.Builder()
            .center(cameraCenterCoordinates)
            .zoom(13.0)
            .build()

        val animatorOptions = MapAnimationOptions.Builder().duration(10000).build()

        mapView.getMapboxMap().flyTo(cameraOptions, animatorOptions)

    }


    private val onIndicatorBearingChangedListener = OnIndicatorBearingChangedListener {
        mapView.getMapboxMap().setCamera(CameraOptions.Builder().bearing(it).build())
    }

    private val onIndicatorPositionChangedListener = OnIndicatorPositionChangedListener {
        mapView.getMapboxMap().setCamera(CameraOptions.Builder().center(it).build())
        mapView.gestures.focalPoint = mapView.getMapboxMap().pixelForCoordinate(it)
    }

    private val onMoveListener = object : OnMoveListener {
        override fun onMoveBegin(detector: MoveGestureDetector) {
            onCameraTrackingDismissed()
        }

        override fun onMove(detector: MoveGestureDetector): Boolean {
            return false
        }

        override fun onMoveEnd(detector: MoveGestureDetector) {}
    }

    private fun onMapReady() {
        mapView.getMapboxMap().setCamera(
            CameraOptions.Builder()
                .zoom(14.0)
                .build()
        )
        mapView.getMapboxMap().loadStyleUri(
            Style.MAPBOX_STREETS
        ) {
            initLocationComponent()
            setupGesturesListener()
        }
    }

    private fun setupGesturesListener() {
        mapView.gestures.addOnMoveListener(onMoveListener)
    }

    private fun initLocationComponent() {
        val locationComponentPlugin = mapView.location
        locationComponentPlugin.updateSettings {
            this.enabled = true
        }
        locationComponentPlugin.addOnIndicatorPositionChangedListener(onIndicatorPositionChangedListener)
        locationComponentPlugin.addOnIndicatorBearingChangedListener(onIndicatorBearingChangedListener)
    }

    private fun onCameraTrackingDismissed() {
        Toast.makeText(mapView.context, "onCameraTrackingDismissed", Toast.LENGTH_SHORT).show()
        mapView.location
            .removeOnIndicatorPositionChangedListener(onIndicatorPositionChangedListener)
        mapView.location
            .removeOnIndicatorBearingChangedListener(onIndicatorBearingChangedListener)
        mapView.gestures.removeOnMoveListener(onMoveListener)
    }


}
