package com.obassignment.data.repository

import com.obassignment.common.Constants
import com.obassignment.data.mappers.CharacterRemoteMapperImpl
import com.obassignment.data.network.ApiService
import com.obassignment.domain.model.charaterlistmodel.ResultModel
import com.obassignment.domain.repository.CharactersRepository

class CharactersRepositoryImpl constructor(
    private val apiService: ApiService,
    private val characterRemoteMapperImpl: CharacterRemoteMapperImpl
) : CharactersRepository {
    override suspend fun getCharacterList(): List<ResultModel> {
        val response = apiService.getCharactersList(
            Constants.PUBLIC_API_KEY,
            Constants.timeStamp,
            Constants.hash()
        )
        return characterRemoteMapperImpl.toModel(response.body()!!)
    }

    override suspend fun getCharacterDetails(characterId: Int): List<ResultModel> {
        val response = apiService.getCharacterDetails(
            characterId,
            Constants.PUBLIC_API_KEY,
            Constants.timeStamp,
            Constants.hash()
        )
        return characterRemoteMapperImpl.toModel(response.body()!!)
    }
}