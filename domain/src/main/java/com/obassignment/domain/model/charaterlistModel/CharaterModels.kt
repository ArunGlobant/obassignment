package com.obassignment.domain.model.charaterlistModel



data class CharaterModel(
    val code: Int,
    val `data`: DataModel,
    val status: String
)


data class ComicsModel(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemModel>,
    val returned: Int
)

data class DataModel(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<ResultModel>,
    val total: Int
)

data class EventsModel(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemModel>,
    val returned: Int
)
data class ItemModel(
    val name: String,
    val resourceURI: String
)
data class ItemXXXModel(
    val name: String,
    val resourceURI: String,
    val type: String
)
data class ResultModel(
    val id: Int,
    val name: String,
    val thumbnail: ThumbnailModel

)

data class SeriesModel(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemModel>,
    val returned: Int
)

data class StoriesModel(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXXXModel>,
    val returned: Int
)

data class ThumbnailModel(
    val extension: String,
    val path: String
)

data class UrlModel(
    val type: String,
    val url: String
)











