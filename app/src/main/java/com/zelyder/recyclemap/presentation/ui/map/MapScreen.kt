package com.zelyder.recyclemap.presentation.ui.map

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import com.mapbox.geojson.Point
import com.mapbox.maps.MapView
import com.mapbox.maps.Style
import com.mapbox.maps.dsl.cameraOptions
import com.mapbox.maps.plugin.annotation.annotations
import com.mapbox.maps.plugin.annotation.generated.CircleAnnotationManager
import com.mapbox.maps.plugin.annotation.generated.CircleAnnotationOptions
import com.mapbox.maps.plugin.annotation.generated.createCircleAnnotationManager

@Composable
fun MapScreen() {
    AndroidView(factory = { context ->
        MapView(context).apply {
            getMapboxMap().loadStyleUri(Style.MAPBOX_STREETS)
            cameraOptions {
                zoom(9.0)
            }
            val pointerAnnotationManager = annotations.createCircleAnnotationManager()
            for (point in points) {
                addPoint(point.first, point.second, pointerAnnotationManager)
            }

        }
    })

}

val points = listOf(
    Pair(37.236489, 55.997487),
    Pair(37.233776, 56.000985),
    Pair(37.216942, 55.996213),
    Pair(37.236489, 55.997487),
    Pair(37.215891, 55.996983),
    Pair(37.211490, 56.001593),
)


fun addPoint(
    longitude: Double, latitude: Double, pointerAnnotationManager: CircleAnnotationManager
) {
    val circleAnnotationOptions =
        CircleAnnotationOptions().withPoint(Point.fromLngLat(longitude, latitude))
            .withCircleRadius(8.0).withCircleColor("#32CD32").withCircleStrokeWidth(2.0)
            .withCircleStrokeColor("#ffffff")

    pointerAnnotationManager.create(circleAnnotationOptions)
}