package platzi.gnarbaiz.testapp.data.repository


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import platzi.gnarbaiz.testapp.data.remote.CharsRemoteDataSource
import platzi.gnarbaiz.testapp.domain.model.CharacterEntity
import platzi.gnarbaiz.testapp.domain.model.Output
import platzi.gnarbaiz.testapp.domain.repository.CharsRepository
import javax.inject.Inject

/**
 * Implementation of CharsRepository
 * @param charsRemoteDataSource the object of remote data source
 */
internal class CharsRepositoryImpl @Inject constructor(
    private val charsRemoteDataSource: CharsRemoteDataSource
) : CharsRepository {
    override suspend fun fetchCharacters(): Flow<Output<List<CharacterEntity>>> {
        return flow {
            emit(Output.loading())
            val result = charsRemoteDataSource.fetchCharacters()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}