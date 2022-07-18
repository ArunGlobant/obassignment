package com.obassignment.presentation.characterDetails

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.obassignment.common.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterDetailsViewModel constructor(private val getCharacterDetailsUseCaseImpl:
                                            GetCharacterDetailsUseCaseImpl):
    ViewModel(){

    private val _characterDetails = MutableStateFlow<CharacterDetailsState>(CharacterDetailsState())
    val characterDetails: StateFlow<CharacterDetailsState> = _characterDetails

    fun getCharacterDetails(characterId: Int){
        viewModelScope.launch {
            val response = getCharacterDetailsUseCaseImpl.getcharaterDetail(characterId)
            when (response) {
                is Resource.Loading -> {
                    _characterDetails.value = CharacterDetailsState(isLoading = true)
                }
                is Resource.Error -> {
                    _characterDetails.value = CharacterDetailsState(error = response.message ?: "")
                   // Log.d("Error:====  ", "" + _characterDetails.value)
                }
                is Resource.Success -> {
                    _characterDetails.value = CharacterDetailsState(data = response.data)
                   // Log.d("data:====  ", "" + _characterDetails.value)
                }
            }
        }
    }
}