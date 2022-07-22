package com.obassignment.data.network

import com.obassignment.common.Constants
import com.obassignment.data.network.dto.characterlistDto.CharacterListDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("v1/public/characters")
    suspend fun getCharactersList(
        @Query("apikey") apiKey: String = Constants.PUBLIC_API_KEY,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash()
    ): Response<CharacterListDTO>


    @GET("v1/public/characters/{characterId}")
    suspend fun getCharacterDetails(
        @Path("characterId") characterId: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
    ): Response<CharacterListDTO>
}