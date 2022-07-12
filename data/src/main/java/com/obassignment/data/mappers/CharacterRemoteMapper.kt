package com.obassignment.data.mappers

import com.obassignment.data.network.dto.characterlistDto.CharacterListDTO
import com.obassignment.domain.model.charaterlistModel.ResultModel

interface CharacterRemoteMapper {
    fun toModel(characterListDTO: CharacterListDTO): List<ResultModel>
}