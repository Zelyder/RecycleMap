package com.zelyder.recyclemap.ui.feed

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.zelyder.recyclemap.R
import com.zelyder.recyclemap.ui.navigation.NavScreen
import com.zelyder.recyclemap.ui.navigation.Navigation

@Composable
fun FeedItem(
    title: String,
    shortDescription: String,
    imageUrl: String,
    //onItemClick: (NavScreen) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier
        .padding(8.dp)
        .fillMaxWidth()
    ) {
        AsyncImage(model = imageUrl,
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = shortDescription,
                style = MaterialTheme.typography.body2)
        }
    }
}

@Preview
@Composable
fun feedItemTest () {
    FeedItem(title = "Title", shortDescription = "shortDescription shortDescription  shortDescription shortDescription shortDescription shortDescription shortDescription shortDescription",
        imageUrl = "https://plus-one.ru/files/image_2020/08/instr_14_04.gif")
}