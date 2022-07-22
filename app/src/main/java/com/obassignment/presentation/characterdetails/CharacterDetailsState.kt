package com.obassignment.presentation.characterdetails

import com.obassignment.common.Constants.Companion.EMPTY_VALUE
import com.obassignment.domain.model.charaterlistmodel.ResultModel

data class CharacterDetailsState(
    var isLoading: Boolean = false,
    var data: List<ResultModel>? = null,
    var error: String = EMPTY_VALUE
)
