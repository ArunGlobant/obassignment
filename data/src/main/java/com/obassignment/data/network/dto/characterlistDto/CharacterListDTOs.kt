package com.obassignment.data.network.dto.characterlistDto


data class CharacterListDTO(
    //@Json(name = "attributionHTML")
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val `data`: DataDTO,
    val etag: String,
    val status: String
)

data class ComicsDTO(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemDTO>,
    val returned: Int
)


data class DataDTO(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<ResultDTO>,
    val total: Int
)

data class EventsDTO(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemDTO>,
    val returned: Int
)

data class ItemDTO(
    val name: String,
    val resourceURI: String
)

data class ItemXXXDTO(
    val name: String,
    val resourceURI: String,
    val type: String
)

data class ResultDTO(
    val comics: ComicsDTO,
    val description: String,
    val events: EventsDTO,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: SeriesDTO,
    val stories: StoriesDTO,
    val thumbnail: ThumbnailDTO,
    val urls: List<UrlDTO>
)

data class SeriesDTO(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemDTO>,
    val returned: Int
)

data class StoriesDTO(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXXXDTO>,
    val returned: Int
)

data class ThumbnailDTO(
    val extension: String,
    val path: String
)

data class UrlDTO(
    val type: String,
    val url: String
)



