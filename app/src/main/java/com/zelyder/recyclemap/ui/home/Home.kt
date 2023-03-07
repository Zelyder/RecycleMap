package com.zelyder.recyclemap.ui.home

import android.content.ClipData.Item
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mapbox.maps.MapView
import com.mapbox.maps.Style
import com.mapbox.maps.dsl.cameraOptions
import com.mapbox.maps.plugin.annotation.annotations
import com.mapbox.maps.plugin.annotation.generated.createCircleAnnotationManager
import com.zelyder.recyclemap.R
import com.zelyder.recyclemap.addPoint
import com.zelyder.recyclemap.points
import com.zelyder.recyclemap.ui.feed.FeedItem
import com.zelyder.recyclemap.ui.learn.LearnItem
import com.zelyder.recyclemap.ui.navigation.NavScreen

enum class HomeSelections(
    @StringRes val title: Int,
    val icon: ImageVector,
    val rout: String
) {
    // иконки заменить используея метод painterResource(id = R.drawable.logo)
    MAP(R.string.home_map, Icons.Outlined.LocationOn, NavScreen.NavMapScreen.route),
    FEED(R.string.home_feed, Icons.Outlined.Home, NavScreen.NavFeedScreen.route),
    LEARN(R.string.home_learn, Icons.Outlined.Place, NavScreen.NavLearnScreen.route),

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
            val selected = item.rout == backStackEntry.value?.destination?.route
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
    val shortDescription: String,
    val imageUrl: String,
)

val feedList = listOf(
Feed("Пластик", "jflksalfkls alfslakfkdsjafl jlasj fkasjkl flksalf jsdaj fdasjlf",
    "https://plus-one.ru/files/image_2020/08/instr_14_04.gif"),
Feed("Бумага", "jflksalfkls alfslakfkdsjafl jlasj fkasjkl flksalf jsdaj fdasjlf",
    "https://plus-one.ru/files/image_2020/08/instr_14_04.gif"),
Feed("Стекло", "jflksalfkls alfslakfkdsjafl jlasj fkasjkl flksalf jsdaj fdasjlf",
    "https://plus-one.ru/files/image_2020/08/instr_14_04.gif"),
Feed("Пластик", "jflksalfkls alfslakfkdsjafl jlasj fkasjkl flksalf jsdaj fdasjlf",
    "https://plus-one.ru/files/image_2020/08/instr_14_04.gif"),
Feed("Пластик", "jflksalfkls alfslakfkdsjafl jlasj fkasjkl flksalf jsdaj fdasjlf",
    "https://plus-one.ru/files/image_2020/08/instr_14_04.gif"),
Feed("Пластик", "jflksalfkls alfslakfkdsjafl jlasj fkasjkl flksalf jsdaj fdasjlf",
    "https://plus-one.ru/files/image_2020/08/instr_14_04.gif"),
Feed("Пластик", "jflksalfkls alfslakfkdsjafl jlasj fkasjkl flksalf jsdaj fdasjlf",
    "https://plus-one.ru/files/image_2020/08/instr_14_04.gif")
)

@Composable
fun FeedScreen() {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(feedList) { item ->
            FeedItem(
                title = item.title,
                imageUrl = item.imageUrl,
                shortDescription = item.shortDescription
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
data class LItem(
    val title: String,
    val image: Int
)
val learnList = listOf(
    LItem("Пластик", R.drawable.plastic),
    LItem("Бумага", R.drawable.plastic),
    LItem("Стекло", R.drawable.plastic),
    LItem("Пластик", R.drawable.plastic),
    LItem("Пластик", R.drawable.plastic),
    LItem("Пластик", R.drawable.plastic),
    LItem("Пластик", R.drawable.plastic)
)
@Preview
@Composable
fun LearnScreen() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(learnList) { item ->
            LearnItem(title = item.title, imageId = item.image)

        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}

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