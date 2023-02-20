package platzi.gnarbaiz.testapp.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import platzi.gnarbaiz.testapp.data.getDummyCharacters
import platzi.gnarbaiz.testapp.data.remote.CharsRemoteDataSource
import platzi.gnarbaiz.testapp.domain.model.Output
import platzi.gnarbaiz.testapp.domain.repository.CharsRepository

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class CharsRepositoryTest {
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    private lateinit var charsRepository: CharsRepository

    @Mock
    lateinit var charsRemoteDataSource: CharsRemoteDataSource


    @Before
    fun setUp() {
        charsRepository = CharsRepositoryImpl(charsRemoteDataSource)
    }

    @Test
    fun `Given Characters When fetchCharacters returns Success`() = runBlocking {
        //GIVEN
        val givenCharacters = getDummyCharacters()
        val givenCharactersOutput = Output.success(givenCharacters)
        val inputFlow = listOf(Output.loading(), givenCharactersOutput)

        `when`(charsRemoteDataSource.fetchCharacters()).thenReturn(givenCharactersOutput)

        //WHEN
        val outputFlow = charsRepository.fetchCharacters().toList()

        //THEN
        assert(outputFlow.size == 2)
        assert(inputFlow[0] == outputFlow[0])
        assert(inputFlow[1] == outputFlow[1])
    }
}