package com.obassignment.presentation.characterlist

import com.obassignment.common.Response
import com.obassignment.domain.model.charaterlistModel.ResultModel
import com.obassignment.domain.repository.CharactersRepository
import com.obassignment.domain.useCase.GetCharactersUseCase


class GetCharactersUseCaseImpl constructor(private val charactersRepository: CharactersRepository) :
    GetCharactersUseCase {
    override suspend fun getCharacterList(): Response<List<ResultModel>> {
        return try {
            val response = charactersRepository.getCharacterList()
            Response.Success(data = response)
        } catch (e: Exception) {
            Response.Error("" + e.localizedMessage)
        }
    }
}

