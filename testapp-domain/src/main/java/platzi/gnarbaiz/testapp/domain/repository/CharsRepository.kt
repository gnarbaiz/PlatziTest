package platzi.gnarbaiz.testapp.domain.repository

import kotlinx.coroutines.flow.Flow
import platzi.gnarbaiz.testapp.domain.model.CharacterEntity
import platzi.gnarbaiz.testapp.domain.model.Output

/**
 * Interface of Chars Repository to expose to other module
 */
interface CharsRepository {

    /**
     * Method to fetch the characters from Repository
     * @return Flow of Outputs with Characters list
     */
    suspend fun fetchCharacters(): Flow<Output<List<CharacterEntity>>>
}