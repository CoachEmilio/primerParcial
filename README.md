Este codigo esta desordenado. 
Tienen que separarlo en files con la arquitectura correcta, y sacarle lo que no sirve.
LET THE GAMES BEGIN

<img src="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgMhBRl2mtxehuaOj0gBpZ13cszM-0CC-D7aXfn7c43Y0yJnLMStnD8EBmdKBw_TE0IDHpsQizKUGMsya4Vy2KrH4JDGjVtWB5EMWCe38ItQAmUvN1r6P_0DwcYb6xz8q0CxgNb4-XvgcE/s1600/I'M+LOOKING+AT++YOU.jpg" alt="Logo" width="2000">

<img src="https://www.pockettactics.com/wp-content/sites/pockettactics/2026/02/pokemon-sandslash.jpg" alt="Logo" width="2000">

Parcial 1: Pokédex App — Android Kotlin 2026 📱

<H1 align="center">
	Romero Quirino, Luis Emilio
</H1>

<p align="center">
	1203234 - Tecnicatura en Desarrollo Software
</p>

<p align="center">
	<a href="https://shields.io"><img alt="Kotlin" src="https://img.shields.io/badge/-Kotlin-7F52FF?style=flat&logo=kotlin&logoColor=white"
 /></a>
</p>
    
📝 Descripción del Proyecto
Resolución técnica del Primer Parcial de la materia Desarrollo de Aplicaciones I. La aplicación consiste en un catálogo interactivo de Pokémon que consume datos de la PokeAPI, implementando un flujo de datos reactivo y eficiente.
El foco principal de este desarrollo es la separación de responsabilidades y el cumplimiento de los estándares de ingeniería de software para dispositivos móviles
.

--------------------------------------------------------------------------------
🏗️ Arquitectura y Patrones
La aplicación sigue estrictamente el patrón MVVM (Model-View-ViewModel) junto con el patrón Repository, garantizando que la interfaz sea una función del estado (UI=f(estado))
.
📂 Estructura de Capas
data.model: Contiene la data class Pokemon, donde se encapsula la lógica de procesamiento (Extracción de ID y formateo de nombres) para mantener el resto de la app limpia [History, 406].
data.repository: Funciona como la Single Source of Truth (Única Fuente de Verdad), abstrayendo el origen de los datos del resto de la aplicación
.
ui.viewmodel: Gestiona el UiState mediante StateFlow, asegurando un flujo unidireccional de datos (UDF) y evitando fugas de memoria al no poseer referencias al Context
.
ui.screen: Implementación de la interfaz declarativa con Jetpack Compose, utilizando funciones @Composable puras
.

--------------------------------------------------------------------------------
🛠️ Stack Tecnológico
Kotlin Coroutines: Para el manejo de operaciones asíncronas sin bloquear el hilo principal de la UI
.
Retrofit & GSON: Bloques de construcción para el consumo de servicios web REST y conversión automática de JSON a objetos Kotlin
.
Coil: Librería para la carga optimizada y asíncrona de imágenes (sprites)
.
Material 3: Uso de componentes avanzados como Scaffold, Card y TopAppBar para una experiencia de usuario moderna y accesible
.

--------------------------------------------------------------------------------
⚡ Optimizaciones y Rendimiento
Gestión de Memoria: Uso de LazyColumn con claves estables (key = { it.id }) para optimizar la recomposición y reducir el uso de CPU/Batería
.
Android Runtime (ART): La aplicación está diseñada para aprovechar la compilación híbrida (AOT + JIT) del sistema, asegurando un "Cold Start" veloz
.
Null Safety: Implementación de operadores idiomáticos de Kotlin (?., ?:) para prevenir errores de tipo NullPointerException durante el parseo de datos externos [History].

--------------------------------------------------------------------------------
🚀 Instalación y Uso
Clonar el repositorio: git clone https://github.com/tu-usuario/parcial1.git
Abrir el proyecto en Android Studio Jellyfish (o superior).
Sincronizar el archivo build.gradle.kts para descargar las dependencias.
Permisos: Asegurarse de que el AndroidManifest.xml incluya el permiso de acceso a la red:
Ejecutar en un dispositivo físico o emulador (preferentemente arquitectura ARM64)
.

--------------------------------------------------------------------------------
🎓 Contexto Académico
Institución: UADE - Facultad de Ingeniería y Ciencias Exactas.
Materia: Desarrollo de Aplicaciones I.
Año: 2026.
Docentes: Peña, Alejandro Francisco | Narducci, Adrián Alberto
