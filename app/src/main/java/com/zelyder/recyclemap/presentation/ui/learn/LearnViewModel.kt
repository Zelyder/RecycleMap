package com.zelyder.recyclemap.presentation.ui.learn

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zelyder.recyclemap.domain.use_case.LearnUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LearnViewModel @Inject constructor(
    private val learnUseCases: LearnUseCases
): ViewModel() {
    private val _state = mutableStateOf(LearnState())
    val state: State<LearnState> = _state

    private var getListJob: Job? = null

    fun getCodesList(id: Int) {
        getListJob?.cancel()
        getListJob =  viewModelScope.launch {
            val items = learnUseCases.getCodesList.invoke(id)
            _state.value = state.value.copy(recycleCodes = items)
        }
    }
}