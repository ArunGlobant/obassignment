package com.obassignment.domain.useCase

import com.obassignment.common.Response
import com.obassignment.domain.model.charaterlistmodel.ResultModel

interface GetCharactersUseCase {
    suspend fun getCharacterList(): Response<List<ResultModel>>
}