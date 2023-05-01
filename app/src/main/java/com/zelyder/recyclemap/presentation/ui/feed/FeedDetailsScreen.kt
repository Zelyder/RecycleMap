package com.zelyder.recyclemap.presentation.ui.feed

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

@Composable
fun FeedDetailsScreen(
    url: String?
) {
    url?.let {

        val state = rememberWebViewState(url = it)
        WebView(
            state = state,
            onCreated = { it.settings.javaScriptEnabled = true }
        )
    } ?: Text(text = "Пустрой URL")
}