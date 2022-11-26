package com.example.inmovapp.vistas


import android.content.Context
import android.content.SharedPreferences
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.inmovapp.R
import kotlinx.coroutines.delay

@Composable
fun Pantalla_carga(navController: NavController){
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    val scaleAnimation:Animatable<Float, AnimationVector1D> = remember {
        Animatable(0F)
    }

    AnimationSplashContent(
        scaleAnimation = scaleAnimation,
        navController = navController,
        durationMillisAnimation = 1500,
        delayScreen = 3000L
    )
    DesignSplashScreen(
        imagePainter = painterResource(id = R.drawable.logo),
        scaleAnimation = scaleAnimation
    )
}

@Composable
fun DesignSplashScreen(
    imagePainter: Painter,
    scaleAnimation: Animatable<Float, AnimationVector1D>
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF174378)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = imagePainter,
                contentDescription = "",
                modifier = Modifier
                    .size(600.dp)
                    .scale(scale = scaleAnimation.value)
            )
            Text(
                text = "Bienvenido!",
                color = Color.Yellow,
                fontSize = 50.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .scale(scale = scaleAnimation.value)
                    .padding(80.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))

        }
    }
}

@Composable
fun AnimationSplashContent(
    scaleAnimation: Animatable<Float, AnimationVector1D>,
    navController: NavController,
    durationMillisAnimation: Int,
    delayScreen: Long
) {
    val context = LocalContext.current
    val save: SharedPreferences = context.getSharedPreferences("Lostanau", Context.MODE_PRIVATE)

    LaunchedEffect(key1 = true){
        scaleAnimation.animateTo(
            targetValue = 0.5F,
            animationSpec = tween(
                durationMillis = durationMillisAnimation,
                easing = {
                    OvershootInterpolator(3F).getInterpolation(it)
                }
            )
        )
        delay(delayScreen)

        val sharedValue = save.getString("id_key","Lostanau")
        if(sharedValue.equals("Lostanau")){
            navController.navigate("ruta_mensaje") {
                popUpTo("ruta_carga") {
                    inclusive = true
                }
            }

        }else{
            navController.navigate("ruta_login"){
                popUpTo("ruta_carga"){
                    inclusive = true
                }
            }

        }



    }
}