package com.obassignment.data.repository

import com.obassignment.common.Constants
import com.obassignment.data.mappers.CharacterRemoteMapperImpl
import com.obassignment.data.network.ApiService
import com.obassignment.data.network.utils.SafeApiRequest
import com.obassignment.domain.model.charaterlistModel.ResultModel
import com.obassignment.domain.repository.CharactersRepository


class CharactersRepositoryImpl constructor(private val apiService: ApiService,
                                           private val characterRemoteMapperImpl: CharacterRemoteMapperImpl
): CharactersRepository, SafeApiRequest() {
    override suspend fun getCharacterList(): List<ResultModel> {
       val response = apiService.getCharactersList(
           Constants.PUBLIC_API_KEY,
           Constants.timeStamp,
           Constants.hash(),
           "")
        return characterRemoteMapperImpl.toModel(response.body()!!)
    }
}