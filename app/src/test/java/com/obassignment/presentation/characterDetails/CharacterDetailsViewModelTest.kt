package com.obassignment.presentation.characterDetails

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.obassignment.common.Resource
import com.obassignment.domain.model.charaterlistModel.*
import com.obassignment.domain.repository.CharacterDetailsRepository
import com.obassignment.domain.repository.CharactersRepository
import io.mockk.MockKAnnotations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class CharacterDetailsViewModelTest{

    @Mock
    lateinit var getCharacterDetailsUseCaseImpl: GetCharacterDetailsUseCaseImpl
    var characterDetailsRepository: CharacterDetailsRepository = mock()
    lateinit var underTest: CharacterDetailsViewModel
    val testDispatcher = TestCoroutineDispatcher()


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(testDispatcher)
        getCharacterDetailsUseCaseImpl = Mockito.spy(GetCharacterDetailsUseCaseImpl(characterDetailsRepository))
        underTest = CharacterDetailsViewModel(getCharacterDetailsUseCaseImpl)
    }

    @Test
    fun `ensure to call  get character details function and get data`()  {

        val thumbnailModel =
            ThumbnailModel("jpg", "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784")
        val comicsModel = ComicsModel(5)
        val seriesModel = SeriesModel(4)
        val storiesModel = StoriesModel(5)
        val eventsModel = EventsModel(2)
        val resultModel = ResultModel(1, "3-D Man", thumbnailModel, comicsModel, storiesModel,
            seriesModel, eventsModel)

        runBlocking {
            Mockito.`when`(getCharacterDetailsUseCaseImpl.getcharaterDetail(1))
                .thenReturn(
                    Resource.Success(listOf<ResultModel>(
                        ResultModel(1, "3-D Man", thumbnailModel, comicsModel, storiesModel,
                    seriesModel, eventsModel)
                    )))

            Mockito.verify (characterDetailsRepository, times(0)).getCharacterDetails(1)
        }
    }

    @Test
    fun `empty charater details test`(){
        runBlocking {
            Mockito.`when`(getCharacterDetailsUseCaseImpl.getcharaterDetail(1))
                .thenReturn(Resource.Success(listOf<ResultModel>()))
            Mockito.verify (characterDetailsRepository, times(0)).getCharacterDetails(1)
        }
    }

    @After
    fun cleanup() {
        Dispatchers.resetMain()
    }
}