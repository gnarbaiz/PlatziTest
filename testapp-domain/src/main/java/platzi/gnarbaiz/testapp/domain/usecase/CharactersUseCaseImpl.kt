package platzi.gnarbaiz.testapp.domain.usecase

import kotlinx.coroutines.flow.Flow
import platzi.gnarbaiz.testapp.domain.model.CharacterEntity
import platzi.gnarbaiz.testapp.domain.model.Output
import platzi.gnarbaiz.testapp.domain.repository.CharsRepository
import javax.inject.Inject

/**
 * Implementation of Characters UseCase
 * @param charsRepository the chars repository object
 */
internal class CharactersUseCaseImpl @Inject constructor(private val charsRepository: CharsRepository) :
    CharactersUseCase {

    override suspend fun execute(): Flow<Output<List<CharacterEntity>>> {
        return charsRepository.fetchCharacters()
    }
}