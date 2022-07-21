package com.obassignment.data.network.di


import com.obassignment.common.Constants
import com.obassignment.data.mappers.CharacterRemoteMapper
import com.obassignment.data.mappers.CharacterRemoteMapperImpl
import com.obassignment.data.network.ApiService
import com.obassignment.data.repository.CharactersRepositoryImpl
import com.obassignment.domain.repository.CharactersRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.annotation.KoinReflectAPI
import org.koin.dsl.bind
import org.koin.dsl.module

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


fun provideApiService(): ApiService{
    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

    return Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
        .create(ApiService::class.java)
}


@KoinReflectAPI
val dataAppModule = module {
    single { provideApiService()  }
}

val dataInterModule = module {
    factory { CharacterRemoteMapperImpl() } bind CharacterRemoteMapper::class
    factory { CharactersRepositoryImpl(get(), get()) } bind CharactersRepository::class
}






