package com.obassignment.data.mappers

import com.obassignment.data.network.dto.characterlistDto.*
import com.obassignment.domain.model.charaterlistModel.*

class CharacterRemoteMapperImpl : CharacterRemoteMapper {
    override fun toModel(characterListDTO: CharacterListDTO): List<ResultModel> {
        return characterListDTO.data?.results?.map { it ->
            ResultModel(
                id = it.id!!,
                name = it.name!!,
                thumbnail = it.thumbnail!!.toDomainThumbnailModel(),
                comics = it.comics!!.toDomainComicsModel(),
                stories = it.stories!!.toDomainStoriesModel(),
                series = it.series!!.toDomainSeriesModel(),
                events = it.events!!.toDomainEventsModel()
            )
        }.orEmpty()
    }

    fun List<ResultDTO>.toDomainResultModel(): List<ResultModel> {
        return map {
            ResultModel(
                id = it.id!!,
                name = it.name!!,
                thumbnail = it.thumbnail!!.toDomainThumbnailModel(),
                comics = it.comics!!.toDomainComicsModel(),
                stories = it.stories!!.toDomainStoriesModel(),
                series = it.series!!.toDomainSeriesModel(),
                events = it.events!!.toDomainEventsModel()
            )
        }
    }

    fun ThumbnailDTO.toDomainThumbnailModel(): ThumbnailModel {
        return ThumbnailModel(
            extension!!, path!!
        )
    }

    fun ComicsDTO.toDomainComicsModel(): ComicsModel {
        return ComicsModel(
            available!!
        )
    }

    fun StoriesDTO.toDomainStoriesModel(): StoriesModel {
        return StoriesModel(
            available!!
        )
    }

    fun SeriesDTO.toDomainSeriesModel(): SeriesModel {
        return SeriesModel(
            available!!
        )
    }

    fun EventsDTO.toDomainEventsModel(): EventsModel {
        return EventsModel(
            available!!
        )
    }
}