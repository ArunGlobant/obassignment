package com.obassignment.presentation.characterDetails

import com.obassignment.common.Response
import com.obassignment.domain.model.charaterlistModel.ResultModel
import com.obassignment.domain.repository.CharactersRepository
import com.obassignment.domain.useCase.GetCharacterDetailsUseCase


class GetCharacterDetailsUseCaseImpl constructor(private val charactersRepository: CharactersRepository) :
    GetCharacterDetailsUseCase {
    override suspend fun getCharacterDetail(characterId: Int): Response<List<ResultModel>> {
        try {
            val response = charactersRepository.getCharacterDetails(characterId)
            return Response.Success(data = response)
        } catch (e: Exception) {
            return Response.Error("" + e.localizedMessage)
        }
    }

}
