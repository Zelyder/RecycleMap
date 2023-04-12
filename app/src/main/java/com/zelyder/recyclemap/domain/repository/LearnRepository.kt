package com.zelyder.recyclemap.domain.repository

import com.zelyder.recyclemap.domain.model.RecycleCode

interface LearnRepository {
    suspend fun getCodesList(id: Int): List<RecycleCode>

}