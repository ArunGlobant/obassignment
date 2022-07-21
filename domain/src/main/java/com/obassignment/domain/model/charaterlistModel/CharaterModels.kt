package com.obassignment.domain.model.charaterlistModel

data class CharaterModel(
    val code: Int,
    val `data`: DataModel,
    val status: String
)

data class ComicsModel(
    val available: Int,
)

data class DataModel(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<ResultModel>,
    val total: Int
)

data class EventsModel(
    val available: Int
)

data class ResultModel(
    val id: Int,
    val name: String,
    val thumbnail: ThumbnailModel,
    val comics: ComicsModel,
    val stories: StoriesModel,
    val series: SeriesModel,
    val events: EventsModel

)

data class SeriesModel(
    val available: Int,
)

data class StoriesModel(
    val available: Int,
)

data class ThumbnailModel(
    val extension: String,
    val path: String
)











