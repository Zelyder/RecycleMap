package com.zelyder.recyclemap.data.data_source

import com.zelyder.recyclemap.domain.model.Feed

interface News {
    suspend fun fetch(): List<Feed>
}