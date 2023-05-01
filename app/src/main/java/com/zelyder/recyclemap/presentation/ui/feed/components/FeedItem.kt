package com.zelyder.recyclemap.presentation.ui.feed.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun FeedItem(
    title: String,
    date: String,
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Spacer(modifier = Modifier.width(16.dp))
    Row(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        AsyncImage(
            modifier = Modifier
                .size(72.dp)
                .clip(RoundedCornerShape(8.dp)),
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.wrapContentHeight().padding(start = 8.dp).height(72.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = date,
                style = MaterialTheme.typography.subtitle2
            )
        }

    }
}

@Preview
@Composable
fun FeedItemTest() {
    FeedItem(
        title = "Сортировка и сбор мусора: системы, проблемы, правила",
        date = "Апр 21, 2023",
        imageUrl = "https://ztbo.ru/file/images/sortirovka-i-sbor-musora.png"
    )
}