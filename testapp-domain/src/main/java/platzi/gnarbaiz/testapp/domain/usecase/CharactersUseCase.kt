package platzi.gnarbaiz.testapp.domain.usecase

import kotlinx.coroutines.flow.Flow
import platzi.gnarbaiz.testapp.domain.model.CharacterEntity
import platzi.gnarbaiz.testapp.domain.model.Output

/**
 * Interface of Characters UseCase to expose to ui module
 */
interface CharactersUseCase {
    /**
     * UseCase Method to fetch the characters from Data Layer
     */
    suspend fun execute(): Flow<Output<List<CharacterEntity>>>
}