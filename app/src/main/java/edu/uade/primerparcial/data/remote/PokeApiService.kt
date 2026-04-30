package edu.uade.primerparcial.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApiService {
    //uso retrofit como lo cometo el profesor en clases
    //la gracia de separar la logica de la api con una interface es que no tengo
    //una lista gigante de https request
    //aqui puedo configurar cuantos pokemones traigo a la app encapsulada
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 251,
        @Query("offset") offset: Int = 0
    ): PokemonResponse
}