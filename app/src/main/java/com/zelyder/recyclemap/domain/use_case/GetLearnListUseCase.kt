package com.zelyder.recyclemap.domain.use_case

import com.zelyder.recyclemap.domain.model.LearnEntity
import com.zelyder.recyclemap.domain.repository.LearnRepository
import kotlinx.coroutines.flow.Flow

class GetLearnListUseCase(
    private val repository: LearnRepository
) {
    operator fun invoke(): Flow<List<LearnEntity>> {
        return repository.getLearnList()
    }
}