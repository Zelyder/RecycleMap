package com.zelyder.recyclemap.domain.use_case.feed

import com.zelyder.recyclemap.domain.model.Feed
import com.zelyder.recyclemap.domain.repository.FeedRepository

class GetFeedListUseCase(
    private val repository: FeedRepository
) {
    suspend operator fun invoke(): List<Feed> {
        return repository.getFeedList()
    }
}