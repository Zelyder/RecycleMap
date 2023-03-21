package com.zelyder.recyclemap.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mapbox.maps.MapView
import com.mapbox.maps.Style
import com.zelyder.recyclemap.R
import com.zelyder.recyclemap.presentation.navigation.*
import com.zelyder.recyclemap.presentation.ui.learn.LearnDetailsScreen
import com.zelyder.recyclemap.presentation.ui.main.HomeScreen
import com.zelyder.recyclemap.presentation.ui.theme.RecycleMapTheme

class MainActivity : ComponentActivity() {

    var mapView: MapView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mapView = findViewById(R.id.mapView)
        mapView?.getMapboxMap()?.loadStyleUri(Style.MAPBOX_STREETS)
        setContent {
            RecycleMapTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    var router: Router? = null

                    NavHost(
                        navController = navController,
                        startDestination = NavScreen.NavHomeScreen.route
                    ) {
                        composable(NavScreen.NavHomeScreen.route) {
                            router = createExternalRouter { screen, params ->
                                navController.navigate(screen, params)
                            }
                            router?.let {
                                HomeScreen(
                                    it
                                )
                            }

                        }
                        composable(
                            NavScreen.NavLearnDetailsScreen(
                                "{${NavConst.LEARN_DETAILS_SCREEN_TITLE}}"
                            ).route
                        ) {
                            val title = it.arguments?.getString(NavConst.LEARN_DETAILS_SCREEN_TITLE)
                            LearnDetailsScreen(title = title)
                        }
                    }
                }
            }
        }
    }
}
