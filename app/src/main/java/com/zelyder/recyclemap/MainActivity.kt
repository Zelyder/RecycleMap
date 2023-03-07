package com.zelyder.recyclemap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mapbox.geojson.Point
import com.mapbox.maps.MapView
import com.mapbox.maps.Style
import com.mapbox.maps.dsl.cameraOptions
import com.mapbox.maps.plugin.annotation.annotations
import com.mapbox.maps.plugin.annotation.generated.CircleAnnotationManager
import com.mapbox.maps.plugin.annotation.generated.CircleAnnotationOptions
import com.mapbox.maps.plugin.annotation.generated.createCircleAnnotationManager
import com.zelyder.recyclemap.ui.home.BottomNavigationBar
import com.zelyder.recyclemap.ui.home.HomeSelections
import com.zelyder.recyclemap.ui.navigation.Navigation
import com.zelyder.recyclemap.ui.navigation.NavScreen
import com.zelyder.recyclemap.ui.theme.RecycleMapTheme

class MainActivity : ComponentActivity() {

    var mapView: MapView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mapView = findViewById(R.id.mapView)
        mapView?.getMapboxMap()?.loadStyleUri(Style.MAPBOX_STREETS)
        setContent {
            RecyclerMapApp()
        }
    }
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
    longitude: Double,
    latitude: Double,
    pointerAnnotationManager: CircleAnnotationManager
) {
    val circleAnnotationOptions = CircleAnnotationOptions()
        .withPoint(Point.fromLngLat(longitude, latitude))
        .withCircleRadius(8.0)
        .withCircleColor("#32CD32")
        .withCircleStrokeWidth(2.0)
        .withCircleStrokeColor("#ffffff")

    pointerAnnotationManager.create(circleAnnotationOptions)
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RecycleMapTheme {
        RecyclerMapApp()
    }
}