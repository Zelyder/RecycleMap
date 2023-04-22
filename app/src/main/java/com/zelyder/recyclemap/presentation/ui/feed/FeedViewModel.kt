package com.zelyder.recyclemap.presentation.ui.feed

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zelyder.recyclemap.domain.use_case.feed.FeedUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val feedUseCases: FeedUseCases
): ViewModel() {
    private val _state = mutableStateOf(FeedState())
    val state: State<FeedState> = _state

    private var getListJob: Job? = null

    fun updateFeedList(){
        getListJob?.cancel()
        getListJob = viewModelScope.launch {
            val items = feedUseCases.getFeedListUseCase.invoke()
            _state.value = state.value.copy(feedList = items)
        }
    }
}