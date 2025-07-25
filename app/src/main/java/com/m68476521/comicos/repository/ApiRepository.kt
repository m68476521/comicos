package com.m68476521.comicos.repository

import arrow.core.Either
import javax.inject.Inject

open class ApiRepository
    @Inject
    constructor(
        private val apiService: ApiService,
    ) {
        // TODO remove this hardCoded
        open suspend fun getSessions(): Either<Throwable, ComicsResponse> =
            Either.catch {
                apiService.getSeasons()
            }
    }
