package com.m68476521.nbat.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.m68476521.nbat.repository.ApiRepository
import com.m68476521.nbat.repository.ImageResponse
import kotlinx.coroutines.launch
import javax.inject.Inject

class MyModel : ViewModel() {
    @Inject
    lateinit var repository1: ApiRepository

    val data = mutableListOf<ImageResponse>()

    fun getData() {
        viewModelScope.launch { data.add(repository1.getSessions()) }
    }
}