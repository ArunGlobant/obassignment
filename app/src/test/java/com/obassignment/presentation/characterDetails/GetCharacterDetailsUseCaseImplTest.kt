package com.obassignment.presentation.characterDetails

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.obassignment.domain.model.charaterlistModel.*
import com.obassignment.domain.repository.CharacterDetailsRepository
import io.mockk.MockKAnnotations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class GetCharacterDetailsUseCaseImplTest{
    var characterDetailsRepository: CharacterDetailsRepository = mock()
    @Mock
    lateinit var getCharacterDetailsUseCaseImpl: GetCharacterDetailsUseCaseImpl
    val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp(){
        MockKAnnotations.init(this)
        Dispatchers.setMain(testDispatcher)
        getCharacterDetailsUseCaseImpl = Mockito.spy(GetCharacterDetailsUseCaseImpl(characterDetailsRepository))
    }
    @Test
    fun `ensure to call  get character details function and get success in response`(){
        val thumbnailModel =
            ThumbnailModel("jpg", "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784")
        val comicsModel = ComicsModel(5)
        val seriesModel = SeriesModel(4)
        val storiesModel = StoriesModel(5)
        val eventsModel = EventsModel(2)

        runBlocking {
            Mockito.`when`(characterDetailsRepository.getCharacterDetails(1))
                .thenReturn(
                    listOf<ResultModel>(
                        ResultModel(1, "3-D Man", thumbnailModel, comicsModel, storiesModel,
                            seriesModel, eventsModel)
                    ))
            Mockito.verify (characterDetailsRepository, times(0)).getCharacterDetails(1)
        }
    }
}