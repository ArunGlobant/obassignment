package com.obassignment.presentation.characterList

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.obassignment.common.Resource
import com.obassignment.data.mappers.CharacterRemoteMapperImpl
import com.obassignment.domain.model.charaterlistModel.*
import com.obassignment.domain.repository.CharactersRepository
import com.obassignment.domain.useCase.GetCharactersUseCase
import io.mockk.MockKAnnotations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class CharaterListViewModelTest{
    @Mock lateinit var getCharactersUseCaseImpl: GetCharactersUseCaseImpl
    var charactersRepository: CharactersRepository = mock()
    lateinit var underTest: CharacterListViewModel
    val testDispatcher = TestCoroutineDispatcher()
    //getCharactersUseCaseImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(testDispatcher)
        getCharactersUseCaseImpl = Mockito.spy(GetCharactersUseCaseImpl(charactersRepository))
        underTest = CharacterListViewModel(getCharactersUseCaseImpl)
    }

    @Test
    fun `ensure to call  getCharacterList function and get data`()  {

        val thumbnailModel =
            ThumbnailModel("jpg", "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784")
        val comicsModel = ComicsModel(5)
        val seriesModel = SeriesModel(4)
        val storiesModel = StoriesModel(5)
        val eventsModel = EventsModel(2)
        val resultModel = ResultModel(1, "3-D Man", thumbnailModel, comicsModel, storiesModel,
            seriesModel, eventsModel)

        runBlocking {
            Mockito.`when`(getCharactersUseCaseImpl.getcharacterList())
                .thenReturn(Resource.Success(listOf<ResultModel>(ResultModel(1, "3-D Man", thumbnailModel, comicsModel, storiesModel,
                    seriesModel, eventsModel))))
            var result = underTest.getCharacterList()

             verify (charactersRepository, times(1)).getCharacterList()
        }
    }

    @Test
    fun `empty charater list test`(){
        runBlocking {
            Mockito.`when`(getCharactersUseCaseImpl.getcharacterList())
                .thenReturn(Resource.Success(listOf<ResultModel>()))
            verify (charactersRepository, times(1)).getCharacterList()
        }
    }

    @After
    fun cleanup() {
        Dispatchers.resetMain()
    }
}