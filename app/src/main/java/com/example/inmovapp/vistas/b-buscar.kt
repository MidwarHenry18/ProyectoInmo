package com.example.inmovapp.vistas

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Shop
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.inmovapp.modelo.Inmuebles
import com.example.inmovapp.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun Pantalla_buscar(navController: NavController, navInit: NavController){
    val TAG = "DATO"
    val nombre = remember { mutableStateOf("") }
    val calificacion = remember { mutableStateOf("") }
    val like = remember { mutableStateOf(0) }
    val precio = remember { mutableStateOf(0) }
    val ubicacion = remember { mutableStateOf("") }
    val provincia = remember { mutableStateOf("") }
    val cbinios = remember { mutableStateOf(0) }
    val chabitaciones = remember { mutableStateOf(0) }
    val descripcion = remember { mutableStateOf("") }
    var inmu = Inmuebles()
    val db = Firebase.firestore
    db.collection("Inmuebles")
        .get()
        .addOnSuccessListener { documents ->
            for (document in documents) {
                inmu = document.toObject(Inmuebles::class.java)
                //igualamos datos de firebase con los de nuestra clase

                nombre.value = inmu.Nombre.toString()
                calificacion.value = inmu.Calificacion.toString()
                like.value = inmu.Like as Int
                precio.value = inmu.Precio as Int
                ubicacion.value = inmu.Ubicacion.toString()
                provincia.value = inmu.Provincia.toString()
                cbinios.value = inmu.CBanios as Int
                chabitaciones.value = inmu.CHabitaciones as Int
                descripcion.value = inmu.Descripcion.toString()

                //Consola
                Log.d(TAG, inmu.Nombre.toString())

            }
        }
        .addOnFailureListener { exception ->
            Log.w(TAG, "Error getting documents: ", exception)
        }


    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally) {
        item {
            Text(text = "Publicaciones de Inmuebles",modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 7.dp), textAlign = TextAlign.Center, fontSize = 25.sp, fontStyle = FontStyle.Normal)

            Row(
                Modifier
                    .fillMaxWidth()
                    .height(72.dp)
                    .padding(start = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Miniatura
                Box(
                    modifier = Modifier
                        .background(color = Color.LightGray, shape = CircleShape)
                        .size(40.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = null
                    )
                }

                Spacer(modifier = Modifier.width(32.dp))

                Column(Modifier.fillMaxWidth()) {
                    // Encabezado
                    Text(text = nombre.value, style = MaterialTheme.typography.h6)

                    // Subtítulo
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                        Text(text = "$ " + precio.value, style = MaterialTheme.typography.body1)
                    }
                }
            }


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 7.dp),

                elevation = 2.dp
            ) {
                Image(
                    painterResource(id = R.drawable.venta),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )

            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(Modifier.padding(start = 16.dp, end = 24.dp, top = 16.dp)) {

                // Texto de ayuda
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = descripcion.value,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.body2,
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "Ubicacion: " + ubicacion.value)
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {

                Box(
                    Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxWidth()
                ) {
                    // Botones
                    Column() {

                        TextButton(onClick = { /*TODO*/ }) {
                            Text(text = "Baños: " + cbinios.value)
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        TextButton(onClick = { /*TODO*/ }) {
                            Text(text = "Habitaciones: "+ chabitaciones.value)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        TextButton(onClick = { /*TODO*/ }) {
                            Text(text = "Calificacion: "+ calificacion.value)
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        TextButton(onClick = { /*TODO*/ }) {
                            Text(text = "Provincia:" + provincia.value)
                        }
                    }


                    // Iconos
                    Row(modifier = Modifier.align(Alignment.CenterEnd)) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(Icons.Default.Favorite, contentDescription = null)
                        }



                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(Icons.Default.Shop , contentDescription = null)
                        }
                    }

                    Spacer(modifier = Modifier.height(60.dp))
                }
            }


        }
    }
}