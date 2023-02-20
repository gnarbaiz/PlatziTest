package platzi.gnarbaiz.testapp.ui.characters

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import platzi.gnarbaiz.testapp.domain.model.Output
import platzi.gnarbaiz.testapp.domain.usecase.CharactersUseCase
import platzi.gnarbaiz.testapp.ui.BaseViewModelTest
import platzi.gnarbaiz.testapp.ui.getDummyCharacters
import platzi.gnarbaiz.testapp.ui.runBlockingMainTest

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class CharactersViewModelTest : BaseViewModelTest() {

    @Mock
    private lateinit var charactersUseCase: CharactersUseCase
    private lateinit var charactersViewModel: CharacterViewModel

    @Before
    fun setUp() {
        charactersViewModel = CharacterViewModel(charactersUseCase)
    }

    @Test
    fun `Given Characters when fetchCharacters should return Success`() = runBlockingMainTest {
        //GIVEN
        val flowQuestions = flowOf(Output.success(getDummyCharacters()))

        //WHEN
        Mockito.doReturn(flowQuestions).`when`(charactersUseCase).execute()
        charactersViewModel.fetchCharacters()

        //THEN
        assert(1 == charactersViewModel.charactersList.value?.data?.size)
    }
}