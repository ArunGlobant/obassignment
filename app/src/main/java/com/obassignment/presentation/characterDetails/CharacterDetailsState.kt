package com.obassignment.presentation.characterDetails

import com.obassignment.common.Constants.Companion.EMPTY_VALUE
import com.obassignment.domain.model.charaterlistModel.ResultModel

data class CharacterDetailsState(
    var isLoading: Boolean = false,
    var data: List<ResultModel>? = null,
    var error: String = EMPTY_VALUE
)
