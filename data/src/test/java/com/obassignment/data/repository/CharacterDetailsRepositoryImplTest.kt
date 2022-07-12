package com.obassignment.data.repository

import com.obassignment.data.mappers.CharacterRemoteMapperImpl
import com.obassignment.data.network.ApiService
import com.obassignment.data.network.dto.characterlistDto.*
import com.obassignment.domain.model.charaterlistModel.ResultModel
import com.obassignment.domain.model.charaterlistModel.ThumbnailModel
import io.mockk.MockKAnnotations
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class CharacterDetailsRepositoryImplTest{

    @Mock
    lateinit var apiService: ApiService
    @Mock
    lateinit var characterRemoteMapperImpl: CharacterRemoteMapperImpl
    lateinit var underTest: CharacterDetailsRepositoryImpl


    @Before
    fun setUp(){
        MockKAnnotations.init(this)
        underTest = Mockito.spy(CharacterDetailsRepositoryImpl(apiService, characterRemoteMapperImpl))
    }
    @Test
    fun `ensure getting success in response`() = runBlocking {

        val thumbnailModel =
            ThumbnailModel("jpg", "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784")
        val resultModel = ResultModel(1, "3-D Man", thumbnailModel)


        val urlDTO = UrlDTO("detail", "http://marvel.com/comics/characters/1011334/3-d_man?utm_campaign=apiRef&utm_source=fcf9a89dd88a8f74de6a92ffa8deccc6")
        val itemDTO = ItemDTO("Avengers","http://gateway.marvel.com/v1/public/characters/1011334")
        val comicsDTO = ComicsDTO(1, "http://gateway.marvel.com/v1/public/characters/1011334/comics", listOf(itemDTO), 2)
        val eventDTO = EventsDTO(1,"http://gateway.marvel.com/v1/public/characters/1011334/comics", listOf(itemDTO), 2)
        val seriesDTO = SeriesDTO(1, "http://gateway.marvel.com/v1/public/characters/1011334/comics", listOf(itemDTO), 2)
        val itemXXXDTO = ItemXXXDTO("","http://gateway.marvel.com/v1/public/characters/1011334", "")
        val storiesDTO = StoriesDTO(1, "http://gateway.marvel.com/v1/public/characters/1011334/comics", listOf(itemXXXDTO), 2)
        val thumbnailDTO = ThumbnailDTO("jpg","http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784")
        val resultDto = ResultDTO(comicsDTO,"", eventDTO, 2, "2014-04-29","3-D Man","http://gateway.marvel.com/v1/public/characters/1011334",
            seriesDTO, storiesDTO, thumbnailDTO, listOf(urlDTO))

        val dataDto = DataDTO(10,1,0,listOf(resultDto), 100)
        val characterListDTO=  CharacterListDTO("html",
            "attribute",
            200,
            "abc",
            dataDto,
            "f0f50f72d6ce5fc",
            "Ok")

        val characterList = listOf(resultModel)

        Mockito.`when`(underTest.getCharacterDetails(1)).thenReturn(characterList)

        assertEquals(true,  characterRemoteMapperImpl.toModel(characterListDTO))
        verify { characterRemoteMapperImpl.toModel(characterListDTO) }

    }

}