package com.zelyder.recyclemap.data.data_source

import com.zelyder.recyclemap.domain.model.Feed
import org.jsoup.nodes.Document

interface News {
    suspend fun fetch(document: Document? = null): List<Feed>
}