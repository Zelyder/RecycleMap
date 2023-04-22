package com.zelyder.recyclemap.domain.repository

import com.zelyder.recyclemap.domain.model.Feed

interface FeedRepository {
    suspend fun getFeedList(): List<Feed>
}