package com.obassignment.presentation.characterDetails

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.obassignment.common.Resource
import com.obassignment.domain.useCase.GetCharacterDetailsUseCase
import com.obassignment.domain.useCase.GetCharactersUseCase

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CharacterDetailsViewModel constructor(private val getCharacterDetailsUseCase: GetCharacterDetailsUseCase):
ViewModel(){

    private val _characterDetails = MutableStateFlow<CharacterDetailsState>(CharacterDetailsState())
    val characterDetails: StateFlow<CharacterDetailsState> = _characterDetails

    
    fun getCharacterDetails(characterId: Int){

        getCharacterDetailsUseCase(characterId).onEach {
            when (it){

                is Resource.Loading -> {
                    _characterDetails.value = CharacterDetailsState(isLoading = true)
                }
                is Resource.Error -> {
                    _characterDetails.value = CharacterDetailsState(error = it.message ?: "")
                    Log.d("Error:====  ",""+_characterDetails.value )
                }
                is Resource.Success -> {
                    _characterDetails.value = CharacterDetailsState(data = it.data)
                    Log.d("data:====  ",""+_characterDetails.value )
                }
            }
        }.launchIn(viewModelScope)
    }

}