package com.m68476521.comicos.component

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.m68476521.comicos.BuildConfig
import com.m68476521.comicos.repository.ApiRepository
import com.m68476521.comicos.repository.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
open class ApiModule {
    @Provides
    @Singleton
    open fun provideKey(): String = ""

    @Provides
    @Singleton
    open fun createClient(
        apiKey: String,
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        var client =
            OkHttpClient
                .Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(RequestInterceptor(apiKey))
                .build()

        return client
    }

    @Provides
    @Singleton
    open fun provideApiService(okHttpClient: OkHttpClient): ApiService =
        Retrofit
            .Builder()
            .baseUrl("https://gateway.marvel.com/")
            .addConverterFactory(GsonConverterFactory.create(createDateFormatter()))
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)

    private fun createDateFormatter(): Gson =
        GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
            .create()

    @Provides
    @Singleton
    open fun provideApiRepository(apiService: ApiService): ApiRepository = ApiRepository(apiService)

    @Provides
    fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }
}

class RequestInterceptor(
    private val apiKey: String = "",
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val ts = System.currentTimeMillis()

        val url =
            chain
                .request()
                .url
                .newBuilder()
                .addQueryParameter("apikey", apiKey)
                .addQueryParameter("hash", "")
                .addQueryParameter("ts", "")
                .build()
        val newRequest =
            chain
                .request()
                .newBuilder()
                .url(url)
                .header("Accept", "application/json")
                .header("Content-type", "application/json")
                .build()
        return chain.proceed(newRequest)
    }
}
