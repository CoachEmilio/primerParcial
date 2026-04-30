Este codigo esta desordenado. 
Tienen que separarlo en files con la arquitectura correcta, y sacarle lo que no sirve.
LET THE GAMES BEGIN

<img src="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgMhBRl2mtxehuaOj0gBpZ13cszM-0CC-D7aXfn7c43Y0yJnLMStnD8EBmdKBw_TE0IDHpsQizKUGMsya4Vy2KrH4JDGjVtWB5EMWCe38ItQAmUvN1r6P_0DwcYb6xz8q0CxgNb4-XvgcE/s1600/I'M+LOOKING+AT++YOU.jpg" alt="Logo" width="2000">

Emilio:

# Contexto de Evaluación: Proyecto Android Kotlin - UADE 2026

Este documento describe los estándares técnicos y arquitectónicos bajo los cuales el profesor evalúa los proyectos de Kotlin en Android Studio. Úsalo para auditar código, refactorizar y asegurar que se cumpla la "separación de responsabilidades".

## 1. Arquitectura Mandatoria: MVVM + Repository
El profesor no evalúa solo si la app "funciona", sino cómo está organizada [1, 2].
*   **View (Composables):** Solo deben encargarse de mostrar el estado (`UI = f(state)`) y capturar eventos del usuario [3, 4].
    *   *Criterio de Evaluación:* **PROHIBIDO** poner lógica de cálculo, validaciones o acceso a datos en el `onClick` de un botón [5, 6].
*   **ViewModel:** Es el cerebro de la pantalla. Debe usar `StateFlow` o `mutableStateOf` para exponer el estado y `viewModelScope` para tareas asíncronas [7, 8].
    *   *Criterio de Evaluación:* El ViewModel **NO** debe conocer clases de la UI como `Context` o `View` para evitar fugas de memoria [Model response history].
*   **Repository:** Funciona como el "bibliotecario". Es el único que sabe si los datos vienen de una API (Retrofit), una base de datos (Room) o SharedPreferences [9, 10].

## 2. Jetpack Compose y Material 3
La interfaz debe ser **Declarativa** y seguir los principios de **Material Design 3** [11-13].
*   **Encastre (Composición):** Se evalúa el uso de funciones pequeñas y reutilizables en lugar de un "God Composable" (una función gigante) [14, 15].
*   **UDF (Unidirectional Data Flow):** El estado baja desde el ViewModel a los Composables; los eventos suben desde los Composables al ViewModel [16, 17].
*   **Scaffold:** Es obligatorio usarlo para organizar la estructura de la pantalla (TopBar, FAB, padding automático) [18, 19].
*   **State Hoisting:** El estado debe "elevarse" al llamador para que los componentes hijos sean *stateless* (sin estado interno), facilitando su testeo [20, 21].

## 3. Manejo de Datos y Red
*   **Retrofit:** Es la herramienta estándar para consumir APIs REST. Se evalúa que se use con interfaces de Kotlin y conversores GSON/Moshi [TP Integrador, 285].
*   **Persistencia:**
    *   Datos simples/configuración: `SharedPreferences` o `DataStore` [22, 23].
    *   Datos estructurados: `Room` (abstracción sobre SQLite) [24, 25].
*   **Internet:** Es mandatorio declarar los permisos en el `AndroidManifest.xml` [Model response history].

## 4. Eficiencia y Runtime (Conceptos Teóricos de Examen)
El profesor evalúa el entendimiento de cómo corre la app en el dispositivo [26]:
*   **ART (Android Runtime):** Uso de compilación híbrida **AOT (Ahead-of-Time)** para mejorar la batería y el rendimiento, y **JIT (Just-in-Time)** para la flexibilidad en ejecución [27, 28].
*   **Dalvik:** Identificarlo como el runtime antiguo (basado solo en JIT) ya deprecado [29, 30].
*   **ARM vs x86:** Entender que Android está optimizado para arquitectura **ARM (RISC)** por su bajo consumo de energía [31, 32].

## 5. "Red Flags" (Lo que baja nota)
*   **Lógica en la Vista:** Cualquier cálculo matemático o regla de negocio dentro de un `@Composable` [5, 33].
*   **Hardcoding:** No usar recursos (`strings.xml`) o no tipar correctamente los datos [1].
*   **Falta de Nulabilidad (Null Safety):** No usar los operadores `?` o `?:` de Kotlin para prevenir cierres inesperados (ANR) [Model response history].
*   **Ignorar el Ciclo de Vida:** No manejar la rotación de pantalla o la pérdida de datos cuando la Activity se pausa [34, 35].

---
**Instrucción para Gemini:** "Al revisar mi código, prioriza detectar violaciones 