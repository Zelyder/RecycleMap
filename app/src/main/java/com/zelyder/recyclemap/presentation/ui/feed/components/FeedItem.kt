package com.zelyder.recyclemap.presentation.ui.feed.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun FeedItem(
    title: String,
    shortDescription: String,
    imageUrl: String,
    //onItemClick: (NavScreen) -> Unit,
    modifier: Modifier = Modifier
) {
    Spacer(modifier = Modifier.width(16.dp))
    Column(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(164.dp),
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            text = title,
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = shortDescription,
            style = MaterialTheme.typography.body2
        )
    }
}

@Preview
@Composable
fun feedItemTest() {
    FeedItem(
        title = "Сортировка и сбор мусора: системы, проблемы, правила",
        shortDescription = "Загрязнение окружающей среды твердыми бытовыми отходами неизменно ведет к нарушению экологического баланса не только в некоторых регионах, но и на всей планете в целом. И неудивительно, что ликвидация вредного влияния на природу подобного рода загрязнений – проблема, которая волнует не только Россию, но и все мировое сообщество.",
        imageUrl = "https://ztbo.ru/file/images/sortirovka-i-sbor-musora.png"
    )
}