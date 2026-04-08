package com.example.jetpackejemplo

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackejemplo.ui.theme.JetpackEjemploTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //En setContent introducimos nuestra escena
        setContent {
            //mostrarAlumno("Juan", 8)
            combinarLayout()
        }


        //enableEdgeToEdge()

    }

    //@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
    //@Preview(showSystemUi = true)
    @Preview(showSystemUi = true)
    @Composable
    fun previsualizar(){
        //mostrarAlumno("Juan", 8)
        //componentesDeLayoutFila()

        //Creo una lista de textos
        val variosTextos: List<textos> = listOf(
            textos("Hola","Estoy en una lista de textos"),
            textos("Esto es otro elemento","De esta forma podemos mostrar muchos elementos"),
            textos("Declarándolos todos","En una lista y mostrándose directamente"),
            textos("Texto de relleno","Texto de relleno aaaaaaaaaaa aaaaaa aaaaa aaaaaa aaaa aaaaaaaa aaaaa aaaa aaaaa aaaa aaa"),
            textos("Texto de relleno","Texto de relleno aaaaaaaaaaa aaaaaa aaaaa aaaaaa aaaa aaaaaaaa aaaaa aaaa aaaaa aaaa aaa"),
            textos("Texto de relleno","Texto de relleno aaaaaaaaaaa aaaaaa aaaaa aaaaaa aaaa aaaaaaaa aaaaa aaaa aaaaa aaaa aaa"),
            textos("Texto de relleno","Texto de relleno aaaaaaaaaaa aaaaaa aaaaa aaaaaa aaaa aaaaaaaa aaaaa aaaa aaaaa aaaa aaa"),
            textos("Texto de relleno","Texto de relleno aaaaaaaaaaa aaaaaa aaaaa aaaaaa aaaa aaaaaaaa aaaaa aaaa aaaaa aaaa aaa"),
            textos("Texto de relleno","Texto de relleno aaaaaaaaaaa aaaaaa aaaaa aaaaaa aaaa aaaaaaaa aaaaa aaaa aaaaa aaaa aaa"),
            textos("Texto de relleno","Texto de relleno aaaaaaaaaaa aaaaaa aaaaa aaaaaa aaaa aaaaaaaa aaaaa aaaa aaaaa aaaa aaa")
        )

        JetpackEjemploTheme() {
            /*
            //Definimos el estado del scroll en una CONSTANTE
            val estadoScroll= rememberScrollState()

            //Dentro de la columna introducimos el modificador y la variable en la que se encuentra el estado
            Column(modifier = Modifier.verticalScroll(estadoScroll)) {
                combinarLayout()
                combinarLayout()
                combinarLayout()
                combinarLayout()
                combinarLayout()
                combinarLayout()
                combinarLayout()
                combinarLayout()
            }
            */

           // build1()

            crearLista(variosTextos)
        }

        //combinarLayout()
    }
}

@Composable
fun mostrarAlumno(nombre: String, nota: Int){

    /*Cargamos un tema de Material Desing, dentro de esta función se encuentra
    * todos los elementos afectados por este tema
    * */
    MaterialTheme() {
        /*
        * Agurpamos los elementos dentro de una columna, esto hace que los elementos
        * no se agrupen de golpe, sino que aparecen en formato columna, también podemos
        * usar modificadores para cambiar atributos del elemento, para ello utilizamos
        * modifier = Modifier.atributo(Cambio), dentro de los paréntesis
        * */
        Column(
            modifier = Modifier.padding(16.dp).fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            /* Para introducir una imagen previamente tenemos que cargarla en el
            * proyecto, debajo del icono de la carpeta arriba a la izquierda, tenemos tres
            * figuras, dentro podemos
            * */
            Image(painter = painterResource(R.drawable.simpson),
                contentDescription = "Los Simpson",
                modifier = Modifier.height(100.dp))

            //Añadimos una separación entre la imagen y el texto
            Spacer(modifier = Modifier.height(16.dp))

            Text("Hola $nombre, tu nota es $nota, buen trabajo", style = MaterialTheme.typography.titleMedium)
            Text("Clase 2º de DAM")
            Text("Kotlin con Jetpack Compose")
        }

    }

}

//Utilizamos el componente Row
@Composable
fun componentesDeLayoutFila(){

    MaterialTheme() {
        Row(modifier = Modifier.padding(16.dp).fillMaxHeight() ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Clase 2º de DAM ", style = MaterialTheme.typography.bodyMedium)
            Text("IES Antonio Gala", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

// Se pueden combinar diferentes layout para formar una estructura fija

@Composable
fun combinarLayout(){
    Row(modifier = Modifier.padding(20.dp, top = 40.dp).background(MaterialTheme.colorScheme.background)) {
        Image(painter = painterResource(R.drawable.simpson),
            contentDescription = "Los Simpson",
            modifier = Modifier.height(100.dp).clip(CircleShape))
        columnaDeEjemplo()
    }
}

@Composable
fun columnaDeEjemplo(){
    Column(modifier = Modifier.padding(start = 5.dp)) {
        Text("Clase 2º de DAM ", color = MaterialTheme.colorScheme.onBackground)
        Spacer(modifier = Modifier.height(10.dp))
        Text("IES Antonio Gala")
    }
}

@Composable
fun build1(){
    val textosD1 = textos("Hola esto usando un data class", "De esta forma puedo estructurar los textos")

    Column() {
        filaConTexto("Hola Clase de 2º de DAM", "Antonio Gala")
        filaConTexto("Ahora puedo crear varios bloques", "Con textos diferentes")
        filaConTextoData(textosD1)
    }

}

//Esto sería un componente de nuestra interfaz
@Composable
fun textoGenericoColumna(texto1: String, texto2: String){
    Column(modifier = Modifier.padding(start = 5.dp)) {
        Text(texto1, color = MaterialTheme.colorScheme.onBackground)
        Spacer(modifier = Modifier.height(10.dp))
        Text(texto2)
    }
}

//Esto sería otro componente de nuestra interfaz
@Composable
fun filaConTexto(texto1: String,texto2: String){
    Row(modifier = Modifier.padding(20.dp, top = 40.dp).background(MaterialTheme.colorScheme.background)) {
        Image(painter = painterResource(R.drawable.simpson),
            contentDescription = "Los Simpson",
            modifier = Modifier.height(100.dp).clip(CircleShape))
        textoGenericoColumna(texto1, texto2)
    }
}


// Funciones con data class
// Se introduce el número maximo de líneas que podemos representar con el parámetro líneas
@Composable
fun textoGenericoColumnaData(dtexto: textos){
    var estadoDesplegado by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(start = 5.dp).clickable{
        estadoDesplegado = !estadoDesplegado //Estamos invirtiendo su valor, si es false pasa a true, si es true pasa a false
    }) {
        Text(dtexto.texto1, color = MaterialTheme.colorScheme.onBackground)
        Spacer(modifier = Modifier.height(10.dp))

        //Hemos introducido el modificador maxLines para permitir mostrar el número de líneas que queramos
        Text(dtexto.texto2, maxLines = if(estadoDesplegado) Int.MAX_VALUE else 1)

    }
}

//Esto sería otro componente de nuestra interfaz
@Composable
fun filaConTextoData(dtexto: textos){
    Row(modifier = Modifier.padding(20.dp, top = 40.dp).background(MaterialTheme.colorScheme.background)) {
        Image(painter = painterResource(R.drawable.simpson),
            contentDescription = "Los Simpson",
            modifier = Modifier.height(100.dp).clip(CircleShape))

        // Pasamos que solo se muestre la primera linea a priori
        textoGenericoColumnaData(dtexto)
    }
}

@Composable
fun crearLista(dComponentes: List<textos>){
    LazyColumn() {
        items(dComponentes) {
            //Estamos utilizando una funcion lamda, el elemento separado de la lista lo guardamos en componente
            componente -> filaConTextoData(componente)
        }
    }
}