package com.obassignment.presentation.characterList

import android.util.Log
import com.obassignment.common.Resource
import com.obassignment.domain.model.charaterlistModel.ResultModel
import com.obassignment.domain.repository.CharactersRepository
import com.obassignment.domain.useCase.GetCharactersUseCase


class GetCharactersUseCaseImpl constructor(private val charactersRepository: CharactersRepository)
    : GetCharactersUseCase {
    override suspend fun getcharacterList(): Resource<List<ResultModel>> {
        try {
            val response = charactersRepository.getCharacterList()
            Log.d("API RESPONSE Success: ", "" + response)
            return Resource.Success(data = response)
        } catch (e: Exception) {
            return Resource.Error(""+e.localizedMessage)
            Log.d("API RESPONSE Error: ", "" + e)
        }
    }
}

