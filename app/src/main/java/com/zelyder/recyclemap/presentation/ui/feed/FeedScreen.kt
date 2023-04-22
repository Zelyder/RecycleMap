package com.zelyder.recyclemap.presentation.ui.feed

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.zelyder.recyclemap.domain.model.Feed
import com.zelyder.recyclemap.presentation.navigation.NavScreen
import com.zelyder.recyclemap.presentation.navigation.Router
import com.zelyder.recyclemap.presentation.ui.feed.components.FeedItem
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

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
fun FeedScreen(
    externalRouter: Router,
    viewModel: FeedViewModel = hiltViewModel(),
    state: FeedState = viewModel.state.value
) {

    val list = state.feedList
    viewModel.updateFeedList()
    LazyColumn {
        items(list) { item ->
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
