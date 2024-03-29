package com.m68476521.comicos.repository

import com.google.gson.annotations.SerializedName

data class ImageResponse(
    val data: List<Image>,
    val pagination: Pagination
)

data class Pagination(
    @SerializedName("total_count")
    val totalCount: Int,
    val count: Int,
    val offset: Int
)

data class Image(
    val type: String,
    val id: String,
    val url: String,
    @SerializedName("embed_url")
    val embedUrl: String,
    val title: String,
    val images: SubImage
)

data class SubImage(
    @SerializedName("fixed_height_small")
    val fixedHeightSmall: ImageSmall,
    val original: ImageOriginal,
    @SerializedName("fixed_height_small_still")
    val fixedHeightSmallStill: ImageSmall,
    @SerializedName("fixed_height_downsampled")
    val fixedHeightDownsampled: ImageSmall,
    @SerializedName("downsized_still")
    val downsizedStill: ImageSmall,
    @SerializedName("fixed_height_still")
    val fixedHeightStill: ImageSmall,
    @SerializedName("downsized_medium")
    val downsizedMedium: ImageSmall,
    @SerializedName("preview_webp")
    val previewWebp: ImageSmall,
    @SerializedName("fixed_width_downsampled")
    val fixedWidthDownsampled: ImageSmall,
    @SerializedName("fixed_width_small")
    val fixedWidthSmall: ImageSmall,
    @SerializedName("preview_gif")
    val previewGif: ImageSmall,
    @SerializedName("fixed_height")
    val fixedHeight: ImageOriginal
)
data class ImageOriginal(
    val url: String
)

data class ImageSmall(
    val url: String?
)