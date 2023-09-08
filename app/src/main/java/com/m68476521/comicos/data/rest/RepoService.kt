package com.m68476521.comicos.data.rest

import okhttp3.ResponseBody
import retrofit2.http.GET




interface RepoService {

    @GET("v1/public/characters")
    fun getCharacters(): ResponseBody
}