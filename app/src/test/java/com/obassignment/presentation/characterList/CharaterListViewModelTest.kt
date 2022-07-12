package com.obassignment.presentation.characterList

import com.obassignment.domain.useCase.GetCharactersUseCase
import io.mockk.MockKAnnotations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify

class CharaterListViewModelTest{

    @Mock lateinit var characterUseCase: GetCharactersUseCase
    lateinit var underTest: CharacterListViewModel
    val testDispatcher = TestCoroutineDispatcher()


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        underTest = CharacterListViewModel(characterUseCase)
    }

    @Test
    fun `ensure to call  invoke function`()  {
        Dispatchers.setMain(testDispatcher)
        underTest.getCharacterList()
        verify { characterUseCase.invoke() }
    }
}