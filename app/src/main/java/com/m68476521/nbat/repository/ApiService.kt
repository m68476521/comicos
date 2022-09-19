package com.m68476521.nbat.repository

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/v1/gifs/trending")
    suspend fun getSeasons(
        @Query("rating") type: String,
        @Query("offset") pagination: Int,
        @Query("limit") limit: Int
    ) : ImageResponse
}