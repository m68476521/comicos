package com.m68476521.comicos.navigation

import kotlinx.serialization.Serializable

@Serializable
object ScreenHome

@Serializable
data class ScreenDetail(
    val albumId: String,
    val albumName: String,
)
