package edu.uade.primerparcial.data.model


// Profe acá el chileno! creo la clase Pokemon.kt encapsulando la logica de este objeto para usarlo
// En mi parcial - asi puedo dejar la logica del modelo en esta parte del proyecto segun arquitectura M-V-MV
data class Pokemon(
    val name: String,
    val url: String
) {
    // Extraemos el ID desde la URL: ".../pokemon/1/" → 1
    // saca el id desde la url:
    // https://pokeapi.co/api/v2/pokemon/25/ -> 25
    val id: Int
        get() = url
            .trimEnd('/')
            .split("/")
            .last()
            .toIntOrNull() ?: 0

    val spriteUrl: String
        get() =
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"

    val nameFormatted: String
        get() = name.replaceFirstChar {
            it.uppercase()
        }
}