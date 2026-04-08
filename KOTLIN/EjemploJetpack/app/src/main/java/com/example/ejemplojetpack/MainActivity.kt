package com.example.ejemplojetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejemplojetpack.ui.theme.EjemploJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjemploJetpackTheme {

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun previsualizacion(){
    // crearColumna()
    val mensajes = listOf("Hola", "como", "estas")
    crearCadenaMensajes(mensajes)
}

@Composable
fun crearColumna(){
    Column(modifier = Modifier.padding(100.dp)) {
        mensaje("Hola clase")
        mostrarSuma(8,3)
    }
}

@Composable
fun crearCadenaMensajes(mensajes: List<String>){
    Column(modifier = Modifier.padding(100.dp)) {
        mensajes.forEach{
            Text(it)
        }
    }
}

@Composable
fun mensaje(cadena:String){
    Text(cadena)
}

@Composable
fun mostrarSuma(num1: Int, num2: Int){
    Text(sumar(num1, num2).toString())
}

fun sumar(num1: Int, num2: Int): Int {
    return num1 + num2
}