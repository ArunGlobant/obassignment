package com.obassignment.presentation.characterdetails

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.obassignment.common.Response
import com.obassignment.domain.model.charaterlistmodel.*
import com.obassignment.domain.repository.CharactersRepository
import io.mockk.MockKAnnotations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class CharacterDetailsViewModelTest {

    @Mock
    lateinit var getCharacterDetailsUseCaseImpl: GetCharacterDetailsUseCaseImpl
    private var charactersRepository: CharactersRepository = mock()
    private lateinit var underTest: CharacterDetailsViewModel
    private val standardTestDispatcher = StandardTestDispatcher()


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(standardTestDispatcher)
        getCharacterDetailsUseCaseImpl =
            Mockito.spy(GetCharacterDetailsUseCaseImpl(charactersRepository))
        underTest = CharacterDetailsViewModel(getCharacterDetailsUseCaseImpl)
    }

    @Test
    fun `ensure to call  get character details function and get data`() {

        val thumbnailModel =
            ThumbnailModel("jpg", "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784")
        val comicsModel = ComicsModel(5)
        val seriesModel = SeriesModel(4)
        val storiesModel = StoriesModel(5)
        val eventsModel = EventsModel(2)

        runBlocking {
            Mockito.`when`(getCharacterDetailsUseCaseImpl.getCharacterDetail(1))
                .thenReturn(
                    Response.Success(
                        listOf(
                            ResultModel(
                                1, "3-D Man", thumbnailModel, comicsModel, storiesModel,
                                seriesModel, eventsModel
                            )
                        )
                    )
                )

            Mockito.verify(charactersRepository, times(0)).getCharacterDetails(1)
        }
    }

    @Test
    fun `empty charater details test`() {
        runBlocking {
            Mockito.`when`(getCharacterDetailsUseCaseImpl.getCharacterDetail(1))
                .thenReturn(Response.Success(listOf<ResultModel>()))
            Mockito.verify(charactersRepository, times(0)).getCharacterDetails(1)
        }
    }

    @After
    fun cleanup() {
        Dispatchers.resetMain()
    }
}