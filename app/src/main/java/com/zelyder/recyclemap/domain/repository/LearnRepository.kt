package com.zelyder.recyclemap.domain.repository

import com.zelyder.recyclemap.domain.model.LearnEntity
import kotlinx.coroutines.flow.Flow

interface LearnRepository {

    fun getLearnList(): Flow<List<LearnEntity>>

    suspend fun insertLearnItem(learnEntity: LearnEntity)

    suspend fun deleteLearnItem(learnEntity: LearnEntity)
}