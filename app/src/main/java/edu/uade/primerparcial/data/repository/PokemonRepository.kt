package edu.uade.primerparcial.data.repository

import edu.uade.primerparcial.data.model.Pokemon
import edu.uade.primerparcial.data.remote.PokeApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonRepository {
    private val api = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PokeApiService::class.java)

    suspend fun getPokemons(): List<Pokemon> {
        return try {
            val response = api.getPokemonList()
            response.results.map { dto ->
                Pokemon(name = dto.name, url = dto.url)
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}
