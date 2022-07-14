package com.obassignment.data.repository

import com.obassignment.common.Constants
import com.obassignment.data.mappers.CharacterRemoteMapper
import com.obassignment.data.mappers.CharacterRemoteMapperImpl
import com.obassignment.data.network.ApiService
import com.obassignment.data.network.utils.SafeApiRequest
import com.obassignment.domain.model.charaterlistModel.ResultModel
import com.obassignment.domain.repository.CharacterDetailsRepository

class CharacterDetailsRepositoryImpl constructor(private val apiService: ApiService,
                                                 private val characterRemoteMapperImpl: CharacterRemoteMapperImpl) : CharacterDetailsRepository, SafeApiRequest() {
    override suspend fun getCharacterDetails(characterId: Int): List<ResultModel> {
        val response =  apiService.getCharacterDetails(
            characterId,
            Constants.PUBLIC_API_KEY,
            Constants.timeStamp,
            Constants.hash())
        return characterRemoteMapperImpl.toModel(response.body()!!)
    }
}