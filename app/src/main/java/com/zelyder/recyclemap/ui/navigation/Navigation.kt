package com.zelyder.recyclemap.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zelyder.recyclemap.ui.home.FeedScreen
import com.zelyder.recyclemap.ui.home.LearnScreen
import com.zelyder.recyclemap.ui.home.MapScreen
import com.zelyder.recyclemap.ui.learn.RecycleCodesScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavScreen.NavFeedScreen.route) {
        composable(NavScreen.NavFeedScreen.route) {
            RecycleCodesScreen()//FeedScreen()
        }
        composable(NavScreen.NavMapScreen.route) {
            MapScreen()
        }
        composable(NavScreen.NavLearnScreen.route) {
            LearnScreen()
        }
    }
}