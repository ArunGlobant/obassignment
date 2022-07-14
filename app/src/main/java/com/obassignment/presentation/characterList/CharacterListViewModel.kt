package com.obassignment.presentation.characterList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.obassignment.common.Resource
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class CharacterListViewModel constructor(private val getCharactersUseCaseImpl: GetCharactersUseCaseImpl):
    ViewModel(){

    private val _characterList = MutableStateFlow<CharacterState>(CharacterState())
    val characterList: StateFlow<CharacterState> = _characterList

    fun getCharacterList(){
        viewModelScope.launch {
            val response = getCharactersUseCaseImpl.invoke()
            when (response) {
                is Resource.Loading -> {
                    _characterList.value = CharacterState(isLoading = true)
                }
                is Resource.Error -> {
                    _characterList.value = CharacterState(error = response.message ?: "")
                    Log.d("Error:====  ", "" + _characterList.value)
                }
                is Resource.Success -> {
                    _characterList.value = CharacterState(data = response.data)
                    Log.d("data:====  ", "" + _characterList.value)
                }
            }
        }
    }
}