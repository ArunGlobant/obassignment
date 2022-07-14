package com.obassignment.domain.useCase

import com.obassignment.common.Resource
import com.obassignment.domain.model.charaterlistModel.ResultModel
import kotlinx.coroutines.flow.Flow

interface GetCharacterDetailsUseCase {
   suspend fun getcharaterDetail(characterId: Int) : Resource<List<ResultModel>>
}