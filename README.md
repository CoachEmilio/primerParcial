Este codigo esta desordenado. 
Tienen que separarlo en files con la arquitectura correcta, y sacarle lo que no sirve.
LET THE GAMES BEGIN

<img src="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgMhBRl2mtxehuaOj0gBpZ13cszM-0CC-D7aXfn7c43Y0yJnLMStnD8EBmdKBw_TE0IDHpsQizKUGMsya4Vy2KrH4JDGjVtWB5EMWCe38ItQAmUvN1r6P_0DwcYb6xz8q0CxgNb4-XvgcE/s1600/I'M+LOOKING+AT++YOU.jpg" alt="Logo" width="2000">

Parcial 1: Pokédex App - Desarrollo de Aplicaciones I (2026)
Este proyecto es la resolución del primer examen parcial de la materia. Se trata de una aplicación nativa desarrollada en Kotlin utilizando Jetpack Compose y Material 3, centrada en el consumo de la PokeAPI siguiendo una arquitectura profesional
.
🏗️ Arquitectura: MVVM + Repository
La aplicación implementa de forma estricta la separación de responsabilidades para garantizar la escalabilidad y el testeo
:
Capa de Datos (Data): Contiene el modelo de dominio y el repositorio.
Capa de Lógica (Logic/ViewModel): Gestiona el estado de la pantalla y procesa los eventos.
Capa de Vista (UI): Funciones @Composable puras que reaccionan al estado
.
1. Modelo de Datos (Pokemon.kt)
Se encapsuló la lógica de procesamiento dentro de la data class. Esto permite que la UI reciba los datos "masticados" y no tenga que realizar lógica de strings en el renderizado
.
// Ubicación: edu.uade.primerparcial.data.model.Pokemon.kt
data class Pokemon(
    val name: String,
    val url: String
) {
    // Extraemos el ID desde la URL para manejar la navegación y sprites
    val id: Int 
        get() = url.trimEnd('/').split("/").last().toIntOrNull() ?: 0

    // URL dinámica para la carga de imágenes con Coil
    val spriteUrl: String 
        get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"

    // Formateo de UI delegado al modelo
    val nameFormatted: String 
        get() = name.replaceFirstChar { it.uppercase() }
}
2. Capa de Datos: Repositorio
El PokemonRepository actúa como la Single Source of Truth (Única Fuente de Verdad), aislando al resto de la app de si los datos vienen de una API (Retrofit) o de una lista fija
.
3. Capa de Lógica: ViewModel
Utiliza StateFlow para exponer un flujo de datos unidireccional (UDF). El ViewModel no conoce clases de la UI como Context para evitar fugas de memoria
.
4. Capa de Vista: Jetpack Compose
La interfaz es declarativa (UI = f(state)). Se utiliza el componente Scaffold para la estructura base y LazyColumn con key para una gestión eficiente de los recursos del sistema (batería y memoria)
.
// Ejemplo de implementación de lista eficiente
LazyColumn(
    contentPadding = PaddingValues(16.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
) {
    items(items = pokemons, key = { it.id }) { pokemon ->
        PokemonItem(pokemon = pokemon)
    }
}
🛠️ Tecnologías y Librerías
Jetpack Compose: Toolkit moderno para UI nativa
.
Retrofit & GSON: Consumo de servicios web REST y conversión de JSON a objetos Kotlin
.
Coil: Carga asíncrona de imágenes mediante AsyncImage
.
Material 3: Sistema de diseño con soporte para Dark Mode y accesibilidad
.
🚀 Cómo correr la app
Sincronizar el proyecto con los archivos de Gradle.
Asegurar que el archivo AndroidManifest.xml incluya el permiso de INTERNET: <uses-permission android:name="android.permission.INTERNET" />
.
Ejecutar en un emulador con arquitectura ARM64 o dispositivo físico para un rendimiento óptimo bajo el runtime ART
.
