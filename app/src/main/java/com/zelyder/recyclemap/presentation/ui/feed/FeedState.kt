package com.zelyder.recyclemap.presentation.ui.feed

import com.zelyder.recyclemap.domain.model.Feed

data class FeedState (
    val feedList: List<Feed> = emptyList()
)