package com.obassignment.presentation.characterDetails

import com.obassignment.domain.model.charaterlistModel.ResultModel

data class CharacterDetailsState(
    var isLoading: Boolean = false,
    var data: List<ResultModel>? = null,
    var error: String = ""
)
