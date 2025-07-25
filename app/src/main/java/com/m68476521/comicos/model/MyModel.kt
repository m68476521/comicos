package com.m68476521.comicos.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.m68476521.comicos.repository.ApiRepository
import com.m68476521.comicos.repository.ComicsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MyModel
    @Inject
    constructor(
        private val repository1: ApiRepository,
    ) : ViewModel() {
        private val comicsResponse = MutableStateFlow(ComicsResponse())

        val comicsResponseData: StateFlow<ComicsResponse> = comicsResponse.asStateFlow()

        fun getData() {
            viewModelScope.launch(Dispatchers.IO) {
                repository1.getSessions().fold({
                    Timber.e("There was an error")
                }, { response ->
                    comicsResponse.update {
                        response
                    }
                })
            }
        }
    }
