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
    val shortDescription: String,
    val imageUrl: String,
)

// https://ztbo.ru/o-tbo/stati/obshchie-stati
val feedList = listOf(
    Feed(
        "Методы и способы переработки мусора (ТБО)",
        "В нашем мире, благодаря тому, что численность населения постоянно увеличивается, потребление ресурсов также неуклонно растет. А потребление восстанавливаемых ресурсов и невосстанавливаемых ресурсов сопровождается увеличением количества отходов. Мусорные свалки, загрязнение водоемов – это все то, к чему приводит жизнедеятельность человека.",
        "https://ztbo.ru/file/images/metodi-i-sposobi-pererabotki-musora-tbo.png"
    ),
    Feed(
        "Технология переработки мусора (ТБО)",
        "Сегодня как никогда более актуальной является проблема утилизации бытовых отходов, неизменно образующихся в процессе жизнедеятельности человека. Эти отходы, постепенно накапливаясь, уже превратились в самое настоящее бедствие. Поэтому правительства технологически развитых стран начинают уделять все большее внимание вопросам охраны окружающей среды, поощряя новые технологии переработки мусора.",
        "https://ztbo.ru/file/images/tehnologija-pererabotki-musora-tbo.png"
    ),
    Feed(
        "Проблемы переработки мусора (ТБО)",
        "Всем известно, как организованы утилизация и сбор твердых бытовых отходов в Западной Европе. В этих странах была сделана ставка на раздельный сбор, максимальное возможное извлечение вторичного сырья и комплексную переработку отходов, благодаря чему любой европейский полигон отходов (ТБО) отличается от отечественного как небо и земля.",
        "https://ztbo.ru/file/images/problemi-pererabotki-musora-tbo.png"
    ),
    Feed(
        "Переработка мусора (ТБО) в топливо",
        "Дорога цивилизации вымощена горами мусора. Это неудивительно, ведь потребление благ цивилизации постоянно растет, а с ним растет и количество отходов. Красочные упаковки, одноразовые изделия и еще многое из того, что делается для широкого потребления, неизменно превращается в утиль.",
        "https://ztbo.ru/file/images/pererabotka-musora-tbo-v-toplivo.png"
    ),
    Feed(
        "«Мусорный рынок»",
        "Проблема утилизации твердых бытовых отходов становится острее и острее с каждым годом, отражаясь на экологической ситуации нашей планеты. Деятельность по сбору и вторичной переработке мусора уже давно стала прибыльным занятием в западных странах, однако в России и СНГ данная отрасль рынка развита недостаточно хорошо, даже не смотря на то, что завод по переработке мусора есть сегодня практически в каждом крупном городе.",
        "https://ztbo.ru/file/images/musornij-rinok.png"
    ),
    Feed(
        "Оборудование для утилизации мусора: прессы, компакторы, шредеры, контейнеры, сортировочные линии",
        "Утилизация отходов в нашей стране постепенно превратилась из деятельности, которая направленна исключительно на защиту окружающей среды в перспективный высокодоходный бизнес. Это и понятно, ведь многие ресурсы сегодня гораздо проще не добывать из земных недр, а получать путем переработки отходов.",
        "https://ztbo.ru/file/images/oborudovanie-dlya-utilizacii-musora.png"
    ),
    Feed(
        "Утилизация мусора в России",
        "Применяемая сегодня в большинстве развитых стран мира переработка бытового мусора является самым важным звеном в длинной цепи процедуры утилизации бытовых отходов. Но если в Европе, Америке Китае и в других странах, отличающихся высоким уровнем технического развития, подобная практика применяется уже достаточно давно, то в России внедрение новых технологий в области переработки вторсырья находится в зародышевом состоянии, и только набирает обороты.",
        "https://ztbo.ru/file/images/utilizaciya-musora-v-rossii.png"
    )
)

@Composable
fun FeedScreen() {
    LazyColumn() {
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