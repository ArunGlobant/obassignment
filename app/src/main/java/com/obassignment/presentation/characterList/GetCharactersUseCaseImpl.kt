package com.obassignment.presentation.characterList

import com.obassignment.common.Response
import com.obassignment.domain.model.charaterlistModel.ResultModel
import com.obassignment.domain.repository.CharactersRepository
import com.obassignment.domain.useCase.GetCharactersUseCase


class GetCharactersUseCaseImpl constructor(private val charactersRepository: CharactersRepository)
    : GetCharactersUseCase {
    override suspend fun getCharacterList(): Response<List<ResultModel>> {
        try {
            val response = charactersRepository.getCharacterList()
            return Response.Success(data = response)
        } catch (e: Exception) {
            return Response.Error(""+e.localizedMessage)
        }
    }
}

