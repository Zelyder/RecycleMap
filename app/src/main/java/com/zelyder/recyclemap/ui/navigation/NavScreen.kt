package com.zelyder.recyclemap.ui.navigation

sealed class NavScreen(val route: String) {
    object NavFeedScreen: NavScreen("home/feed")
    object NavMapScreen: NavScreen("home/map")
    object NavLearnScreen: NavScreen("home/learn")
    data class NavFeedDetails(val endPoint: String) : NavScreen("home/feed/$endPoint")
}
