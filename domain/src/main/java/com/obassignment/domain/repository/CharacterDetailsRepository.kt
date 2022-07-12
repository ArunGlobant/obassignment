package com.obassignment.domain.repository

import com.obassignment.domain.model.charaterlistModel.ResultModel

interface CharacterDetailsRepository {
    suspend fun getCharacterDetails(characterId: Int):List<ResultModel>
}