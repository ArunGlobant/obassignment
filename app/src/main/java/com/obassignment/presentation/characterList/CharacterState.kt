package com.obassignment.presentation.characterList

import com.obassignment.domain.model.charaterlistModel.ResultModel

data class CharacterState(
    var isLoading: Boolean = false,
    var data: List<ResultModel>? = null,
    var error: String = ""
)
