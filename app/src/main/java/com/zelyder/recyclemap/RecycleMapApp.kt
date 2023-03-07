package com.zelyder.recyclemap

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.zelyder.recyclemap.ui.home.BottomNavigationBar
import com.zelyder.recyclemap.ui.home.HomeSelections
import com.zelyder.recyclemap.ui.navigation.Navigation
import com.zelyder.recyclemap.ui.theme.RecycleMapTheme

@Composable
fun RecyclerMapApp() {
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
                        navController.navigate(it.rout)
                    }
                )
            },
            content = {
                Navigation(navController = navController)
            }
        )
    }
}