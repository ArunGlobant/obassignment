package com.obassignment.data.mappers

import com.obassignment.data.network.dto.characterlistDto.CharacterListDTO
import com.obassignment.domain.model.charaterlistModel.ResultModel

class CharacterRemoteMapperImpl : CharacterRemoteMapper {
    override fun toModel(characterListDTO: CharacterListDTO): List<ResultModel> {
        return characterListDTO.data.results?.map { it ->
            ResultModel(
                id = it.id,
                name = it.name,
                thumbnail = it.thumbnail.toDomainThumbnailModel()

            )
        }.orEmpty()
    }
}