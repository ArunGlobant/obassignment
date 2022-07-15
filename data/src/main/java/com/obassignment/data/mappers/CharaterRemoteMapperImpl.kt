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


    fun CharacterListDTO.toDomainCharaterModel():CharaterModel{
        return CharaterModel(
            code = code!!,
            data = data!!.toDomainDataModel(),
            status = status!!
        )
    }

    fun List<ResultDTO>.toDomainResultModel(): List<ResultModel>{
        return map{

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

    fun DataDTO.toDomainDataModel(): DataModel {
        return DataModel(
            count = count!!,
            limit = limit!!,
            offset = offset!!,
            results = results!!.toDomainResultModel(),
            total = total!!
        )
    }
}