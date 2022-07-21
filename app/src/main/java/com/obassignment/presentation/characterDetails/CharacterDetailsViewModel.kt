package com.obassignment.presentation.characterDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.obassignment.common.Constants.Companion.EMPTY_VALUE
import com.obassignment.common.Response
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterDetailsViewModel constructor(
    private val getCharacterDetailsUseCaseImpl:
    GetCharacterDetailsUseCaseImpl
) : ViewModel() {

    private val _characterDetails = MutableStateFlow(CharacterDetailsState())
    val characterDetails: StateFlow<CharacterDetailsState> = _characterDetails

    fun getCharacterDetails(characterId: Int) {
        viewModelScope.launch {
            when (val response = getCharacterDetailsUseCaseImpl.getCharacterDetail(characterId)) {
                is Response.Loading -> {
                    _characterDetails.value = CharacterDetailsState(isLoading = true)
                }
                is Response.Error -> {
                    _characterDetails.value =
                        CharacterDetailsState(error = response.message ?: EMPTY_VALUE)
                }
                is Response.Success -> {
                    _characterDetails.value = CharacterDetailsState(data = response.data)
                }
            }
        }
    }
}