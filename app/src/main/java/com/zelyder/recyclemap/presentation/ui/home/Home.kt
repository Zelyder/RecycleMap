package com.zelyder.recyclemap.presentation.ui.home

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
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
import com.zelyder.recyclemap.presentation.ui.feed.components.FeedItem
import com.zelyder.recyclemap.presentation.ui.learn.components.LearnItem
import com.zelyder.recyclemap.presentation.navigation.NavConst
import com.zelyder.recyclemap.presentation.navigation.NavScreen
import com.zelyder.recyclemap.presentation.navigation.Router
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

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


data class Feed(
    val title: String,
    val imageUrl: String,
    val date: String,
    val url: String
)

// https://ztbo.ru/o-tbo/stati/obshchie-stati
val feedList = listOf(
    Feed(
        "Методы и способы переработки мусора (ТБО)",
        "https://ztbo.ru/file/images/metodi-i-sposobi-pererabotki-musora-tbo.png",
        "Апр 21, 2023",
        "Петр"
    ),
    Feed(
        "Технология переработки мусора (ТБО)",
        "https://ztbo.ru/file/images/tehnologija-pererabotki-musora-tbo.png",
        "Апр 21, 2023",
        "https://radiosputnik.ria.ru/20230420/podmoskove-1866733479.html"
    ),
    Feed(
        "Проблемы переработки мусора (ТБО)",
        "https://ztbo.ru/file/images/problemi-pererabotki-musora-tbo.png",
        "Апр 21, 2023",
        "https://radiosputnik.ria.ru/20230420/podmoskove-1866733479.html"
    ),
    Feed(
        "Переработка мусора (ТБО) в топливо",
        "https://ztbo.ru/file/images/pererabotka-musora-tbo-v-toplivo.png",
        "Апр 21, 2023",
        "https://radiosputnik.ria.ru/20230420/podmoskove-1866733479.html"
    ),
    Feed(
        "«Мусорный рынок»",
        "https://ztbo.ru/file/images/musornij-rinok.png",
        "Апр 21, 2023",
        "https://radiosputnik.ria.ru/20230420/podmoskove-1866733479.html"
    ),
    Feed(
        "Оборудование для утилизации мусора: прессы, компакторы, шредеры, контейнеры, сортировочные линии",
        "https://ztbo.ru/file/images/oborudovanie-dlya-utilizacii-musora.png",
        "Апр 21, 2023",
        "https://radiosputnik.ria.ru/20230420/podmoskove-1866733479.html"
    ),
    Feed(
        "Утилизация мусора в России",
        "https://ztbo.ru/file/images/utilizaciya-musora-v-rossii.png",
        "Апр 21, 2023",
        "https://radiosputnik.ria.ru/20230420/podmoskove-1866733479.html"
    )
)

@Composable
fun FeedScreen(externalRouter: Router) {
    LazyColumn() {
        items(feedList) { item ->
            FeedItem(
                title = item.title,
                imageUrl = item.imageUrl,
                date = item.date,
                modifier = Modifier.clickable {
                    val encodedUrl = URLEncoder.encode(item.url, StandardCharsets.UTF_8.toString())
                    externalRouter.routeTo(NavScreen.NavFeedDetailsScreen(encodedUrl).route)
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

data class LItem(
    val id: Int,
    val title: Int,
    val image: Int,
    val description: Int,
)

val learnList = listOf(
    LItem(id = 0, R.string.plastic, R.drawable.plastic, R.string.plastic_description),
    LItem(id = 1, R.string.paper, R.drawable.paper, R.string.paper_description),
    LItem(id = 2, R.string.metal, R.drawable.metal, R.string.metal_description),
    LItem(
        id = 3,
        R.string.organic_materials,
        R.drawable.organic_materials,
        R.string.cloth_description
    ),
    LItem(id = 4, R.string.glass, R.drawable.glass, R.string.glass_description),
    LItem(
        id = 5,
        R.string.composite_materials,
        R.drawable.composite_materials,
        R.string.hazardous_waste_description
    ),
    LItem(id = 6, R.string.batteries, R.drawable.batteries, R.string.batteries_description),
    LItem(
        id = 7,
        R.string.hazardous_waste,
        R.drawable.hazardous_waste,
        R.string.hazardous_waste_description
    ),
    LItem(id = 8, R.string.cloth, R.drawable.clothes, R.string.cloth_description),
    LItem(id = 9, R.string.light_bulbs, R.drawable.light_bulbs, R.string.light_bulbs_description),
    LItem(id = 10, R.string.appliances, R.drawable.appliances, R.string.appliances_description),
    LItem(id = 11, R.string.tetra_pack, R.drawable.tetra_pack, R.string.tetra_pack_description),
    LItem(id = 12, R.string.caps, R.drawable.caps, R.string.caps_description),
)

@Composable
fun LearnScreen(externalRouter: Router) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(learnList) { item ->
            LearnItem(
                title = stringResource(id = item.title),
                imageId = item.image,
                modifier = Modifier.clickable {
                    val bundle = Bundle().apply {
                        putInt(NavConst.LEARN_DETAILS_SCREEN_ID, item.id)
                    }
                    externalRouter.routeTo(
                        NavScreen.NavLearnDetailsScreen(item.id.toString()).route,
                        bundle
                    )
                })
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Preview(showBackground = true)
@Composable
fun LearnScreenPrev() {
    LearnScreen(FakeRouter())
}