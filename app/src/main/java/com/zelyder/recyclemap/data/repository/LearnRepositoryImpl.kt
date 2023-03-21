package com.zelyder.recyclemap.data.repository

import com.zelyder.recyclemap.data.data_source.LearnDao
import com.zelyder.recyclemap.domain.model.LearnEntity
import com.zelyder.recyclemap.domain.repository.LearnRepository
import kotlinx.coroutines.flow.Flow

class LearnRepositoryImpl(
    private val dao : LearnDao
) : LearnRepository {
    override fun getLearnList(): Flow<List<LearnEntity>> {
        return dao.getList()
    }

    override suspend fun insertLearnItem(learnEntity: LearnEntity) {
        dao.insertLearn(learnEntity)
    }

    override suspend fun deleteLearnItem(learnEntity: LearnEntity) {
        dao.deleteLearn(learnEntity)
    }
}