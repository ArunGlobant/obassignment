package com.obassignment.domain.useCase

import com.obassignment.common.Response
import com.obassignment.domain.model.charaterlistModel.ResultModel

interface GetCharactersUseCase {
    suspend fun getCharacterList(): Response<List<ResultModel>>
}