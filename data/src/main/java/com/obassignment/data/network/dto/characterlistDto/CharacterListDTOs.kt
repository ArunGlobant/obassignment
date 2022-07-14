package com.obassignment.data.network.dto.characterlistDto

import com.squareup.moshi.Json


data class CharacterListDTO(
    @Json(name = "attributionHTML")
    val attributionHTML: String? = null,
    @Json(name = "attributionText")
    val attributionText: String? = null,
    @Json(name = "code")
    val code: Int? = null,
    @Json(name = "copyright")
    val copyright: String? = null,
    @Json(name = "data")
    val `data`: DataDTO? = null,
    @Json(name = "etag")
    val etag: String? = null,
    @Json(name = "status")
    val status: String? = null
)

data class ComicsDTO(
    @Json(name = "available")
    val available: Int? = null,
    @Json(name = "collectionURI")
    val collectionURI: String? = null,
    @Json(name = "items")
    val items: List<ItemDTO>? = null,
    @Json(name = "returned")
    val returned: Int? = null
)


data class DataDTO(
    @Json(name = "count")
    val count: Int? = null,
    @Json(name = "limit")
    val limit: Int? = null,
    @Json(name = "offset")
    val offset: Int? = null,
    @Json(name = "results")
    val results: List<ResultDTO>? = null,
    @Json(name = "total")
    val total: Int? = null
)

data class EventsDTO(
    @Json(name = "available")
    val available: Int? = null,
    @Json(name = "collectionURI")
    val collectionURI: String? = null,
    @Json(name = "items")
    val items: List<ItemDTO>? = null,
    @Json(name = "returned")
    val returned: Int? = null
)

data class ItemDTO(
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "resourceURI")
    val resourceURI: String? = null
)

data class ItemXXXDTO(
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "resourceURI")
    val resourceURI: String? = null,
    @Json(name = "type")
    val type: String? = null
)

data class ResultDTO(
    @Json(name = "comics")
    val comics: ComicsDTO? = null,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "events")
    val events: EventsDTO? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "modified")
    val modified: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "resourceURI")
    val resourceURI: String? = null,
    @Json(name = "series")
    val series: SeriesDTO? = null,
    @Json(name = "stories")
    val stories: StoriesDTO? = null,
    @Json(name = "thumbnail")
    val thumbnail: ThumbnailDTO? = null,
    @Json(name = "urls")
    val urls: List<UrlDTO>? = null
)

data class SeriesDTO(
    @Json(name = "available")
    val available: Int? = null,
    @Json(name = "collectionURI")
    val collectionURI: String? = null,
    @Json(name = "items")
    val items: List<ItemDTO>? = null,
    @Json(name = "returned")
    val returned: Int? = null
)

data class StoriesDTO(
    @Json(name = "available")
    val available: Int? = null,
    @Json(name = "collectionURI")
    val collectionURI: String? = null,
    @Json(name = "items")
    val items: List<ItemXXXDTO>? = null,
    @Json(name = "returned")
    val returned: Int? = null
)

data class ThumbnailDTO(
    @Json(name = "extension")
    val extension: String? = null,
    @Json(name = "path")
    val path: String? = null
)

data class UrlDTO(
    @Json(name = "type")
    val type: String? = null,
    @Json(name = "url")
    val url: String? = null
)



