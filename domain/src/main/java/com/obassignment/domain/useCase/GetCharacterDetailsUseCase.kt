package com.obassignment.domain.useCase

import com.obassignment.common.Response
import com.obassignment.domain.model.charaterlistmodel.ResultModel

interface GetCharacterDetailsUseCase {
    suspend fun getCharacterDetail(characterId: Int): Response<List<ResultModel>>
}