package com.obassignment.data.mappers

import com.obassignment.data.network.dto.characterlistdto.CharacterListDTO
import com.obassignment.domain.model.charaterlistmodel.ResultModel

interface CharacterRemoteMapper {
    fun toModel(characterListDTO: CharacterListDTO): List<ResultModel>
}