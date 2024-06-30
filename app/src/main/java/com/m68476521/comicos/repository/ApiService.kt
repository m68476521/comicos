package com.m68476521.comicos.repository

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/v1/public/comics")
    suspend fun getSeasons(
//        @Query("rating") type: String,
//        @Query("offset") pagination: Int,
//        @Query("limit") limit: Int
    ) : ComicsResponse
}