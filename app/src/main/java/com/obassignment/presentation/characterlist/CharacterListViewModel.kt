package com.obassignment.presentation.characterlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.obassignment.common.Constants.Companion.EMPTY_VALUE
import com.obassignment.common.Response
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class CharacterListViewModel constructor(private val getCharactersUseCaseImpl: GetCharactersUseCaseImpl) :
    ViewModel() {

    private val _characterList = MutableStateFlow(CharacterState())
    val characterList: StateFlow<CharacterState> = _characterList

    fun getCharacterList() {
        viewModelScope.launch {
            when (val response = getCharactersUseCaseImpl.getCharacterList()) {
                is Response.Loading -> {
                    _characterList.value = CharacterState(isLoading = true)
                }
                is Response.Error -> {
                    _characterList.value = CharacterState(error = response.message ?: EMPTY_VALUE)
                }
                is Response.Success -> {
                    _characterList.value = CharacterState(data = response.data)
                }
            }
        }
    }
}