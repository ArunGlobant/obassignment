package com.obassignment.presentation.di

import com.obassignment.domain.useCase.GetCharacterDetailsUseCase
import com.obassignment.domain.useCase.GetCharactersUseCase
import com.obassignment.presentation.characterDetails.CharacterDetailsViewModel
import com.obassignment.presentation.characterDetails.GetCharacterDetailsUseCaseImpl
import com.obassignment.presentation.characterList.CharacterListViewModel
import com.obassignment.presentation.characterList.GetCharactersUseCaseImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.annotation.KoinReflectAPI
import org.koin.dsl.bind
import org.koin.dsl.module

@KoinReflectAPI
val viewModelMoudle = module {
    viewModel { CharacterListViewModel(get()) }
    viewModel { CharacterDetailsViewModel(get()) }
}

val useCaseInterModule = module {
    factory { GetCharactersUseCaseImpl(get()) } bind GetCharactersUseCase::class
    factory { GetCharacterDetailsUseCaseImpl(get()) } bind GetCharacterDetailsUseCase::class

}