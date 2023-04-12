package com.zelyder.recyclemap.presentation.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zelyder.recyclemap.presentation.navigation.NavScreen
import com.zelyder.recyclemap.presentation.navigation.Router
import com.zelyder.recyclemap.presentation.navigation.createExternalRouter
import com.zelyder.recyclemap.presentation.ui.home.*
import com.zelyder.recyclemap.presentation.ui.map.MapScreen
import com.zelyder.recyclemap.presentation.ui.theme.RecycleMapTheme

@Composable
fun HomeScreen(router: Router) {
    RecycleMapTheme {
        // A surface container using the 'background' color from the theme
        val navController = rememberNavController()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                BottomNavigationBar(
                    items = listOf(
                        HomeSelections.MAP,
                        HomeSelections.FEED,
                        HomeSelections.LEARN
                    ),
                    navController = navController,
                    onItemClick = {
                        navController.navigate(it.route)
                    }
                )
            },
            content = {padding ->
                Box(modifier = Modifier.padding(padding)) {
                    Navigation(navController = navController, router)
                }
            }
        )
    }
}

@Composable
private fun Navigation(navController: NavHostController, router: Router) {
    NavHost(navController = navController, startDestination = NavScreen.NavFeedScreen.route) {
        composable(NavScreen.NavFeedScreen.route) {
            FeedScreen()
        }
        composable(NavScreen.NavMapScreen.route) {
            MapScreen()
        }
        composable(NavScreen.NavLearnScreen.route) {
            LearnScreen(externalRouter = router)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RecycleMapTheme {
        HomeScreen(createExternalRouter { _, _ -> })
    }
}