package com.zelyder.recyclemap.presentation.ui.home

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ImportContacts
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.zelyder.recyclemap.R
import com.zelyder.recyclemap.presentation.navigation.FakeRouter
import com.zelyder.recyclemap.presentation.navigation.NavScreen
import com.zelyder.recyclemap.presentation.ui.learn.LearnScreen

enum class HomeSelections(
    @StringRes val title: Int,
    val icon: ImageVector,
    val route: String
) {
    MAP(R.string.home_map, Icons.Outlined.LocationOn, NavScreen.NavMapScreen.route),
    FEED(R.string.home_feed, Icons.Outlined.Home, NavScreen.NavFeedScreen.route),
    LEARN(R.string.home_learn, Icons.Outlined.ImportContacts, NavScreen.NavLearnScreen.route),

}

@Composable
fun BottomNavigationBar(
    items: List<HomeSelections>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (HomeSelections) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.DarkGray,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = stringResource(id = item.title)
                        )
                        if (selected) {
                            Text(
                                text = stringResource(item.title),
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LearnScreenPrev() {
    LearnScreen(FakeRouter())
}