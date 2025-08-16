package com.m68476521.comicos.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.m68476521.comicos.home.data.HomeIntent
import com.m68476521.comicos.home.data.HomeViewState
import com.m68476521.comicos.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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

    private val _state = MutableStateFlow(HomeViewState())
    val state: StateFlow<HomeViewState> = _state

    fun handleIntent(intent: HomeIntent) {
        viewModelScope.launch {
            when (intent) {
                is HomeIntent.LoadComics -> {
                    getComics()
                }

                is HomeIntent.SelectComic -> {
                    _state.update {
                        it.copy(
                            currentComicSelected = intent.comic
                        )
                    }
                }
            }
        }
    }

    fun getComics() {
        viewModelScope.launch(Dispatchers.IO) {
            repository1.getSessions().fold({
                Timber.e("There was an error")
            }, { response ->
                _state.update {
                    it.copy(
                        comicsResponse = response
                    )
                }
            })
        }
    }
}
