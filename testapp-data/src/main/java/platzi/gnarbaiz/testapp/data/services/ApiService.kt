package platzi.gnarbaiz.testapp.data.services


import platzi.gnarbaiz.testapp.domain.model.CharacterEntity
import retrofit2.Response
import retrofit2.http.GET

/**
 * Retrofit API Service
 */
interface ApiService {

    @GET("/api/characters")
    suspend fun getCharacters(): Response<List<CharacterEntity>>
}