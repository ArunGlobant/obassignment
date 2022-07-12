package com.obassignment.domain.model.di

import com.obassignment.domain.useCase.GetCharacterDetailsUseCase
import com.obassignment.domain.useCase.GetCharactersUseCase
import org.koin.core.annotation.KoinReflectAPI
import org.koin.dsl.module


@KoinReflectAPI
val domainAppModule = module {

    factory { GetCharactersUseCase(get()) }
    factory { GetCharacterDetailsUseCase(get()) }
}