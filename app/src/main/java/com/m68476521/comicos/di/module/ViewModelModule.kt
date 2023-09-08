package com.m68476521.comicos.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.m68476521.comicos.ViewModelFactory
import dagger.Binds
import dagger.Module

import dagger.multibindings.IntoMap
import javax.inject.Singleton


@Singleton
@Module

abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    abstract fun bindListViewModel(listViewModel: ListViewModel?): ViewModel?

//    @Binds
//    @IntoMap
//    @ViewModelKey(DetailsViewModel::class)
//    abstract fun bindDetailsViewModel(detailsViewModel: DetailsViewModel?): ViewModel?

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory?): ViewModelProvider.Factory?
}