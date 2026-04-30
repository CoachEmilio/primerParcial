package edu.uade.primerparcial.data.remote

data class PokemonResponse(
    val results: List<PokemonDto>
)

data class PokemonDto(
    val name: String,
    val url: String
)