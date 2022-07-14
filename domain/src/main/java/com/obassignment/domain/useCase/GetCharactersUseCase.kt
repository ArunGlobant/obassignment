package com.obassignment.domain.useCase

import com.obassignment.common.Resource
import com.obassignment.domain.model.charaterlistModel.ResultModel
import kotlinx.coroutines.flow.Flow

interface GetCharactersUseCase {
   suspend fun getcharacterList() : Resource<List<ResultModel>>
}