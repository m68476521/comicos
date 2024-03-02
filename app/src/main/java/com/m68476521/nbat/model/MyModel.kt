package com.m68476521.nbat.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.m68476521.nbat.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import javax.inject.Inject

@HiltViewModel

class MyModel @Inject constructor(val repository1: ApiRepository )
: ViewModel() {

    val data = mutableListOf<ResponseBody>()

    fun getData() {
        viewModelScope.launch { data.add(repository1.getSessions()) }
    }
}