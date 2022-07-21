package com.obassignment.domain.repository

import com.obassignment.domain.model.charaterlistModel.ResultModel

interface CharactersRepository {
    suspend fun getCharacterList(): List<ResultModel>
    suspend fun getCharacterDetails(characterId: Int): List<ResultModel>
}