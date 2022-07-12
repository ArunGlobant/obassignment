package com.obassignment.domain.useCase

import com.obassignment.common.Resource
import com.obassignment.domain.model.charaterlistModel.ResultModel
import com.obassignment.domain.model.charaterlistModel.ThumbnailModel
import com.obassignment.domain.repository.CharactersRepository
import io.mockk.MockKAnnotations
import io.mockk.verify

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class GetCharactersUseCaseTest{

    @Mock
    lateinit var charactersRepository: CharactersRepository
    lateinit var underTest: GetCharactersUseCase

    @Before
    fun setUp(){
        MockKAnnotations.init(this)
        underTest = GetCharactersUseCase(charactersRepository)
    }
    @Test
    fun `ensure getting success in response`(){
        val thumbnailModel = ThumbnailModel("jpg", "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784")
        val resultModel = ResultModel(1, "3-D Man", thumbnailModel)
        val characterList = listOf(resultModel)

        assertEquals(true,  underTest.invoke())
        verify { (Resource.Success(characterList)) }
    }

    @Test
    fun `ensure getting null in response`(){
        val characterList = listOf(null)
        assertEquals(true,  underTest.invoke())
        verify { (Resource.Success(characterList)) }
    }
    @Test
    fun `ensure getting blank in response`(){
        val thumbnailModel = ThumbnailModel("", "")
        val resultModel = ResultModel(0,"",thumbnailModel)
        val characterList = listOf(null)
        assertEquals(true,  underTest.invoke())
        verify { (Resource.Success(characterList)) }
    }
}