package com.obassignment.domain.useCase

import android.util.Log
import com.obassignment.common.Resource

import com.obassignment.domain.model.charaterlistModel.ResultModel
import com.obassignment.domain.repository.CharacterDetailsRepository
import com.obassignment.domain.repository.CharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class GetCharacterDetailsUseCase constructor(private val characterDetailsRepository: CharacterDetailsRepository){
     operator fun invoke(characterId: Int) : Flow<Resource<List<ResultModel>>> = flow {

        emit(Resource.Loading(null))
        try {
            val response = characterDetailsRepository.getCharacterDetails(characterId)
            Log.d("API RESPONSE Success: ",""+response)
            emit(Resource.Success(data = response))

        }catch (e: Exception){
            emit(Resource.Error("Error Occured"))
            Log.d("API RESPONSE Error: ",""+e)
        }
    }
}
