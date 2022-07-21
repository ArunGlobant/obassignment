package com.obassignment.presentation.characterList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.obassignment.common.Response
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class CharacterListViewModel constructor(private val getCharactersUseCaseImpl: GetCharactersUseCaseImpl):
    ViewModel(){

    private val _characterList = MutableStateFlow<CharacterState>(CharacterState())
    val characterList: StateFlow<CharacterState> = _characterList

    fun getCharacterList(){
        viewModelScope.launch {
            val response = getCharactersUseCaseImpl.getCharacterList()
            when (response) {
                is Response.Loading -> {
                    _characterList.value = CharacterState(isLoading = true)
                }
                is Response.Error -> {
                    _characterList.value = CharacterState(error = response.message ?: "")
                }
                is Response.Success -> {
                    _characterList.value = CharacterState(data = response.data)
                }
            }
        }
    }
}