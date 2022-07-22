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


    private fun ThumbnailDTO.toDomainThumbnailModel(): ThumbnailModel {
        return ThumbnailModel(
            extension!!, path!!
        )
    }

    private fun ComicsDTO.toDomainComicsModel(): ComicsModel {
        return ComicsModel(
            available!!
        )
    }

    private fun StoriesDTO.toDomainStoriesModel(): StoriesModel {
        return StoriesModel(
            available!!
        )
    }

    private fun SeriesDTO.toDomainSeriesModel(): SeriesModel {
        return SeriesModel(
            available!!
        )
    }

    private fun EventsDTO.toDomainEventsModel(): EventsModel {
        return EventsModel(
            available!!
        )
    }
}