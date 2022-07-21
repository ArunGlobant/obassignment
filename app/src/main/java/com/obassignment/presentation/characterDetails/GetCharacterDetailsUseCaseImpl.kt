package com.obassignment.presentation.characterDetails

import com.obassignment.common.Response
import com.obassignment.domain.model.charaterlistModel.ResultModel
import com.obassignment.domain.repository.CharacterDetailsRepository
import com.obassignment.domain.useCase.GetCharacterDetailsUseCase


class GetCharacterDetailsUseCaseImpl constructor(private val characterDetailsRepository: CharacterDetailsRepository)
    : GetCharacterDetailsUseCase {
    override suspend fun getCharacterDetail(characterId: Int): Response<List<ResultModel>> {
        try {
            val response = characterDetailsRepository.getCharacterDetails(characterId)
            return Response.Success(data = response)
        } catch (e: Exception) {
            return Response.Error(""+e.localizedMessage)
        }
    }

}
