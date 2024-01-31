package com.m68476521.nbat.repository

open class ApiRepository(
    private val apiService: ApiService
) {
    // TODO remove this hardCoded
    open suspend fun getSessions() = apiService.getSeasons()
}