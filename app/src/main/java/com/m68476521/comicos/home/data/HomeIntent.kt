package com.m68476521.comicos.home.data

import com.m68476521.comicos.repository.ComicsResponse

sealed class HomeIntent {
    object LoadComics : HomeIntent()
}

data class HomeViewState(
    val loading: Boolean = false,
    val error: String? = null,
    val comicsResponse: ComicsResponse? = null,
)