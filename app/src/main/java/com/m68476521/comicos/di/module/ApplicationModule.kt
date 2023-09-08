package com.m68476521.comicos.di.module

import com.m68476521.comicos.data.rest.RepoService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Singleton
//@Module(includes = ViewModelModule.java)


@Module(includes = [ViewModelModule::class])
interface AppComponent {

class ApplicationModule {

    private val BASE_URL = "https://api.github.com/"

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit? {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitService(retrofit: Retrofit): RepoService? {
        return retrofit.create(RepoService::class.java)
    }
}