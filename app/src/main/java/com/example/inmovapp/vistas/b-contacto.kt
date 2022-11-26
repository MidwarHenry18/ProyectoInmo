package com.example.inmovapp.vistas

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.inmovapp.R
import com.example.inmovapp.componentes.TextSubTitleBase

@Composable
fun Pantalla_contacto(navController: NavController, navInit: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(20.dp)
    ){
        HeaderStatesUI(navController,navInit)
        BodyStatesUI()
    }

}

@Composable
fun HeaderStatesUI(navController: NavController, navInit: NavController) {
    TextSubTitleBase("Lista de contactos ")
}

@Composable
fun BodyStatesUI() {
    val scrollState = rememberScrollState()
    Box(
        Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(10.dp))
            .background(Color.White)
            .verticalScroll(scrollState)
    ) {
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){

            Spacer(modifier = Modifier.height(10.dp))
            StateDevicesObjet(
                "LaEncontre",
                "Portal inmobiliario en Perú. Venta y alquiler de casas, departamentos, oficinas y terrenos",
                painterResource(id = R.drawable.ic_launcher_foreground),
                "987 234 652"
            )

            Spacer(modifier = Modifier.height(10.dp))
            StateDevicesObjet(
                "PROPERATI",
                "Encuentra casas, apartamentos, terrenos en venta, alquileres, proyectos inmobiliarios",
                painterResource(id = R.drawable.ic_launcher_foreground),
                "987 234 652"
            )

            Spacer(modifier = Modifier.height(10.dp))
            StateDevicesObjet(
                "Mak Inmobiliaria",
                "Empresas e instituciones que deseen comprar o vender una propiedad ",
                painterResource(id = R.drawable.ic_launcher_foreground),
                "987 234 652"
            )
            Spacer(modifier = Modifier.height(10.dp))

            StateDevicesObjet(
                "RE/MAX Perú",
                "íder mundial en inmobiliaria, inversiones, agentes inmobiliarios, bienes raíces",
                painterResource(id = R.drawable.ic_launcher_foreground),
                "987 234 652"
            )
            Spacer(modifier = Modifier.height(10.dp))

            StateDevicesObjet(
                "Venta de Casas - Urbania.pe",
                "Menorca Inversiones es una empresa peruana con mas de 24 años de trayectoria en el sector inmobiliario. Posada del Sol y Villa Killari son proyectos",
                painterResource(id = R.drawable.ic_launcher_foreground),
                "987 234 652"
            )
            Spacer(modifier = Modifier.height(100.dp))

        }


    }
}



@Composable
fun StateDevicesObjet(text: String, des: String, icon: Painter, devices: Any) {
    Surface(
        elevation = 6.dp,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Cyan)
    ) {
        Box(
            Modifier
                .clip(shape = RoundedCornerShape(10.dp))
                .background(MaterialTheme.colors.secondary)
        ) {

            Row(
                Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){

                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = text,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 18.sp,
                        color = MaterialTheme.colors.onBackground
                    )
                    Text(
                        text = des,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 12.sp,
                        color = MaterialTheme.colors.onBackground
                    )
                    Text(
                        text ="Teléfono : $devices",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 12.sp,
                        color = MaterialTheme.colors.onBackground
                    )
                }


            }
        }
    }

}