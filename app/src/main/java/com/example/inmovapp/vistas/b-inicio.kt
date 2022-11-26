package com.example.inmovapp.vistas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.inmovapp.R
import org.intellij.lang.annotations.JdkConstants
@Composable
fun Pantalla_Home(navController: NavController, navInit: NavController){

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally) {
        item {
            Text(text = "INMOBILIARIA",modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 7.dp), textAlign = TextAlign.Center, fontSize = 35.sp, fontStyle = FontStyle.Normal, color = Color(0xFF174378))
            Text(text = "COMPRA Y VENTA",modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 7.dp), textAlign = TextAlign.Center, fontSize = 18.sp, fontStyle = FontStyle.Normal)

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 7.dp),

                elevation = 2.dp
            ) {
                Image(
                    painterResource(id = com.example.inmovapp.R.drawable.casa),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
                Button(onClick = { /*TODO*/ },colors = ButtonDefaults.textButtonColors(
                    backgroundColor = Color(0xFF174378), contentColor = Color.White) ){
                    Text(text = "Casas")
                }


            }
            Spacer(modifier = Modifier.height(10.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 7.dp),

                elevation = 2.dp
            ) {
                Image(
                    painterResource(id = com.example.inmovapp.R.drawable.depa),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
                Button(onClick = { /*TODO*/ },colors = ButtonDefaults.textButtonColors(
                    backgroundColor = Color(0xFF174378), contentColor = Color.White) ){
                    Text(text = "Depertamentos")
                }


            }
            Spacer(modifier = Modifier.height(10.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 7.dp),

                elevation = 2.dp
            ) {
                Image(
                    painterResource(id = com.example.inmovapp.R.drawable.terrer),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
                Button(onClick = { /*TODO*/ },colors = ButtonDefaults.textButtonColors(
                    backgroundColor = Color(0xFF174378), contentColor = Color.White) ){
                    Text(text = "Terrenos")
                }


            }
            Spacer(modifier = Modifier.height(10.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 7.dp),

                elevation = 2.dp
            ) {
                Image(
                    painterResource(id = com.example.inmovapp.R.drawable.local),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
                Button(onClick = { /*TODO*/ },colors = ButtonDefaults.textButtonColors(
                    backgroundColor = Color(0xFF174378), contentColor = Color.White) ){
                    Text(text = "Locales Comerciales")
                }


            }

            Button(onClick = {  }, modifier = Modifier
                .padding(0.dp, 7.dp)
                .height(50.dp),colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color(0xFF174378), contentColor = Color.White))
            {
                Text(text = "+ Mostrar más")
            }

            Spacer(modifier = Modifier.height(50.dp))


        }

    }
}