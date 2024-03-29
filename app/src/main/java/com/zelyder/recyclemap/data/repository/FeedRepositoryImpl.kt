package com.zelyder.recyclemap.data.repository

import com.zelyder.recyclemap.data.data_source.News
import com.zelyder.recyclemap.domain.model.Feed
import com.zelyder.recyclemap.domain.repository.FeedRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FeedRepositoryImpl(val newsList: List<News>): FeedRepository {
    override suspend fun getFeedList(): List<Feed> = withContext(Dispatchers.IO){
        newsList.map { it.fetch() }.flatten()
    }
}