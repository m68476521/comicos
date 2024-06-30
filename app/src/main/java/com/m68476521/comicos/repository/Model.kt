package com.m68476521.comicos.repository

import com.google.gson.annotations.SerializedName

data class ComicsResponse(
    val code: Int? = null,
    val status: String? = null,
    val data: DataResponse? = null
)

data class DataResponse(
    val offset: Int? = null,
    val limit: Int? = null,
    val total: Int? = null,
    val count: Int? = null,
    val results: List<Results>? = null
)

data class Results(
    val id: Int? = null,
    val digitalId : Int? = null,
    val title: String? = null,
    val issueNumber: Int? = null,
    val variantDescription:String? = null,
    val description:String? = null,
    val modified:String? = null,
    val isbn:String? = null,
    val upc:String? = null,
    val diamondCode:String? = null,
    val ean:String? = null,
    val issn:String? = null,
    val format:String? = null,
    val pageCount: Int? = null,
    //val textObjects:String? = null,
    val resourceURI:String? = null,
    val urls: List<UrlData>? = null,
    val series: Serie? = null,
    val variants: List<Variant>? = null,
    val collections: List<Variant>? = null,
    val collectedIssues: List<Variant>? = null,
    val dates: List<DateData>? = null,
    val prices: List<Price>? = null,
    val thumbnail: Thumbnail? = null,
    val images: List<Thumbnail>? = null,
    val creators: Creator? = null,
    val characters: Characters? = null,
    val stories: Storie? = null,
    val events: Event? = null
)

data class  UrlData(
    val type: String? = null,
    val url: String? = null
)
data class Serie(
    val resourceURI: String? = null,
    val name: String? = null
)

data class Variant(
    val resourceURI: String? = null,
    val name: String? = null
)
data class DateData(
    val type: String? = null,
    val date: String? = null
)
data class Price(
    val type: String? = null,
    val price: Double? = null
)
data class Thumbnail(
    val path: String? = null,
    val extension: String? = null
)

data class Creator(
    val available: Int? = null,
    val collectionURI: String? = null,
    val items: List<ItemCreator>? = null,
    val returned: Int? = null
)

data class ItemCreator(
    val resourceURI: String? = null,
    val name: String? = null,
    val role: String? = null
)

data class Characters(
    val available: Int? = null,
    val collectionURI: String? = null,
    val items: List<ItemCreator>? = null,
    val returned: Int? = null
)

data class Storie(
    val available: Int? = null,
    val collectionURI: String? = null,
    val items: List<ItemStorie>? = null,
    val returned: Int? = null
)

data class ItemStorie(
    val resourceURI: String? = null,
    val name: String? = null,
    val type: String? = null
)

data class Event(
    val available: Int? = null,
    val collectionURI: String? = null,
    val items: List<ItemStorie>? = null,
    val returned: Int? = null
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