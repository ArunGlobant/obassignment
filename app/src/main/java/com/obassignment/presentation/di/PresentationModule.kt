package com.obassignment.presentation.di

import com.obassignment.presentation.characterDetails.CharacterDetailsViewModel
import com.obassignment.presentation.characterList.CharacterListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.annotation.KoinReflectAPI
import org.koin.dsl.module

@KoinReflectAPI
val viewModelMoudle = module{
    viewModel { CharacterListViewModel(get()) }
    viewModel { CharacterDetailsViewModel(get()) }
}