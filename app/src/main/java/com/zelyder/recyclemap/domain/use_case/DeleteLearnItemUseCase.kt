package com.zelyder.recyclemap.domain.use_case

import com.zelyder.recyclemap.domain.model.LearnEntity
import com.zelyder.recyclemap.domain.repository.LearnRepository

class DeleteLearnItemUseCase(
    private val repository: LearnRepository
) {
    suspend operator fun invoke(learnEntity: LearnEntity) {
//        repository.deleteLearnItem(learnEntity)
    }
}