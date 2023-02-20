package platzi.gnarbaiz.testapp.data.remote

import platzi.gnarbaiz.testapp.data.BaseRemoteDataSource
import platzi.gnarbaiz.testapp.data.services.ApiService
import platzi.gnarbaiz.testapp.domain.model.CharacterEntity
import platzi.gnarbaiz.testapp.domain.model.Output
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * RemoteDataSource of Characters API service
 * @param apiService the object of api service
 */
class CharsRemoteDataSource @Inject constructor(
    private val apiService: ApiService, retrofit: Retrofit
) : BaseRemoteDataSource(retrofit) {

    /**
     * Method to fetch the characters from CharsRemoteDataSource
     * @return Outputs with list of Characters
     */
    suspend fun fetchCharacters(): Output<List<CharacterEntity>> {
        return getResponse(
            request = { apiService.getCharacters() },
            defaultErrorMessage = "Error fetching Characters"
        )
    }
}