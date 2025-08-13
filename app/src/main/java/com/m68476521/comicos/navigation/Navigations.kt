package com.m68476521.comicos.navigation

import kotlinx.serialization.Serializable

@Serializable
data class ScreenHome(val start: Boolean = true)

@Serializable
data class ScreenDetail(
    val image: String,
    val id: String,
)
