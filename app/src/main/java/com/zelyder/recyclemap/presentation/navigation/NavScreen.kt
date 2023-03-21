package com.zelyder.recyclemap.presentation.navigation

sealed class NavScreen(val route: String, val titleResourceId: Int = -1) {

    object NavHomeScreen: NavScreen("home")
    object NavFeedScreen: NavScreen("home/feed")
    object NavMapScreen: NavScreen("home/map")
    object NavLearnScreen: NavScreen("home/learn")

    data class NavLearnDetailsScreen(val title: String) : NavScreen("home/learn/details/$title")
    data class NavFeedDetails(val endPoint: String) : NavScreen("home/feed/$endPoint")
}
