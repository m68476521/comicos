package com.m68476521.comicos

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton


@Singleton
class ViewModelFactory @Inject constructor(creators: Map<Class<out ViewModel?>?, Provider<ViewModel?>?>) :
    ViewModelProvider.Factory {
    private val creators: Map<Class<out ViewModel?>, Provider<ViewModel?>>

    init {
        this.creators = creators
    }

    @NonNull
    fun <T : ViewModel?> create(@NonNull modelClass: Class<T?>): T {
        var creator: Provider<out ViewModel?>? = creators[modelClass]
        if (creator == null) {
            for ((key, value): Map.Entry<Class<out ViewModel?>?, Provider<ViewModel?>?> in creators) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }
        requireNotNull(creator) { "unknown model class $modelClass" }
        return try {
            creator.get()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}