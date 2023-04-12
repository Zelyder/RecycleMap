package com.zelyder.recyclemap.domain.use_case

import com.zelyder.recyclemap.domain.model.RecycleCode
import com.zelyder.recyclemap.domain.repository.LearnRepository

class GetCodesListUseCase(
    private val repository: LearnRepository
) {
    suspend operator fun invoke(id: Int): List<RecycleCode> {
        return repository.getCodesList(id)
    }
}