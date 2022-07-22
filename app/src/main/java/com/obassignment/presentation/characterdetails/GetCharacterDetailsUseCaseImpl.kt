package com.obassignment.presentation.characterdetails

import com.obassignment.common.Response
import com.obassignment.domain.model.charaterlistmodel.ResultModel
import com.obassignment.domain.repository.CharactersRepository
import com.obassignment.domain.useCase.GetCharacterDetailsUseCase


class GetCharacterDetailsUseCaseImpl constructor(private val charactersRepository: CharactersRepository) :
    GetCharacterDetailsUseCase {
    override suspend fun getCharacterDetail(characterId: Int): Response<List<ResultModel>> {
        return try {
            val response = charactersRepository.getCharacterDetails(characterId)
            Response.Success(data = response)
        } catch (e: Exception) {
            Response.Error("" + e.localizedMessage)
        }
    }

}
