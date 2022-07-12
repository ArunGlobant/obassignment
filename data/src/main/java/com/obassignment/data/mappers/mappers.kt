package com.obassignment.data.mappers

import com.obassignment.data.network.dto.characterlistDto.CharacterListDTO
import com.obassignment.data.network.dto.characterlistDto.DataDTO
import com.obassignment.data.network.dto.characterlistDto.ResultDTO
import com.obassignment.data.network.dto.characterlistDto.ThumbnailDTO
import com.obassignment.domain.model.charaterlistModel.CharaterModel
import com.obassignment.domain.model.charaterlistModel.DataModel
import com.obassignment.domain.model.charaterlistModel.ThumbnailModel
import com.obassignment.domain.model.charaterlistModel.ResultModel


fun CharacterListDTO.toDomainCharaterModel():CharaterModel{
    return CharaterModel(
        code = code,
        data = data.toDomainDataModel(),
        status = status
    )
}

fun List<ResultDTO>.toDomainResultModel(): List<ResultModel>{
    return map{

        ResultModel(
            id = it.id,
            name = it.name,
            thumbnail = it.thumbnail.toDomainThumbnailModel(),
        )
    }
}

fun ThumbnailDTO.toDomainThumbnailModel(): ThumbnailModel {
    return ThumbnailModel(
        extension, path
    )
}

fun DataDTO.toDomainDataModel(): DataModel{
    return DataModel(
        count = count,
        limit = limit,
        offset = offset,
        results = results.toDomainResultModel(),
        total = total
    )
}











