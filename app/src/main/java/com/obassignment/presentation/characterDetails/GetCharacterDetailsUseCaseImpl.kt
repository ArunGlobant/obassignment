package com.obassignment.presentation.characterDetails

import android.util.Log
import com.obassignment.common.Resource
import com.obassignment.domain.model.charaterlistModel.ResultModel
import com.obassignment.domain.repository.CharacterDetailsRepository
import com.obassignment.domain.useCase.GetCharacterDetailsUseCase


class GetCharacterDetailsUseCaseImpl constructor(private val characterDetailsRepository: CharacterDetailsRepository)
    : GetCharacterDetailsUseCase {
    override suspend fun getcharaterDetail(characterId: Int): Resource<List<ResultModel>> {
        try {
            val response = characterDetailsRepository.getCharacterDetails(characterId)
            Log.d("API RESPONSE Success: ", "" + response)
            return Resource.Success(data = response)
        } catch (e: Exception) {
            return Resource.Error(""+e.localizedMessage)
            Log.d("API RESPONSE Error: ", "" + e)
        }
    }

}
