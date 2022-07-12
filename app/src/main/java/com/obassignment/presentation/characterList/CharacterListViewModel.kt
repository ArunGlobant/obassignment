package com.obassignment.presentation.characterList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.obassignment.common.Resource
import com.obassignment.domain.useCase.GetCharactersUseCase

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CharacterListViewModel constructor(private val characterUseCase: GetCharactersUseCase):
ViewModel(){

    private val _characterList = MutableStateFlow<CharacterState>(CharacterState())
    val characterList: StateFlow<CharacterState> = _characterList

    
    fun getCharacterList(){

        characterUseCase().onEach {
            when (it){

                is Resource.Loading -> {
                    _characterList.value = CharacterState(isLoading = true)
                }
                is Resource.Error -> {
                    _characterList.value = CharacterState(error = it.message ?: "")
                    Log.d("Error:====  ",""+_characterList.value )
                }
                is Resource.Success -> {
                    _characterList.value = CharacterState(data = it.data)
                    Log.d("data:====  ",""+_characterList.value )
                }
            }
        }.launchIn(viewModelScope)
    }

}