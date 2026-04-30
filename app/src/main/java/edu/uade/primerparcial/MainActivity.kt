package edu.uade.primerparcial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import edu.uade.primerparcial.Aux.PokemonListFinal
import edu.uade.primerparcial.ui.theme.PokeComposeAPITheme


class MainActivity : ComponentActivity() {
    //Documentacion para el profesor
    //aca escribo a mano diciendo que entendi
    //importar a mano para separar logica, repositorios, vistas y el viewmodel
    //a modo de separar responsabilidades
    // View(Usuario) <-> Viewmodel "el 10" <-> Model (logica de app)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokeComposeAPITheme {
                //PokemonListScreen() // para mostrar el punto de partida de la clase
                //esto fue lo que comenté y lo cambié en Aux.kt con PokemonListFinal()
                PokemonListFinal()
            }
        }
    }
}