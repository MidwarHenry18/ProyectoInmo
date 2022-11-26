package com.example.inmovapp.vistas

import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.inmovapp.R
import com.example.inmovapp.componentes.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun Pantalla_registro(navController: NavController){
    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = Color(0xFF174378),
            modifier = Modifier.background(Color.Magenta)) {
            Icon(imageVector = Icons.Default.ArrowBackIos,
                contentDescription = "Atrás",
                tint = Color.White,
                modifier = Modifier
                    .clickable { navController.popBackStack() }
                    .width(70.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Atrás", color = Color.White)
        }
    }, content = { screen_register(navController)})
}

@Composable
fun screen_register(navController: NavController){

    val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)
        .verticalScroll(state = scrollState)
        .background(Color(0xFF174378))
    ) {

        var emailValue = remember { mutableStateOf("")}
        var passValue = remember { mutableStateOf("") }

        var codProduct = remember { mutableStateOf("") }
        var codActiv = remember { mutableStateOf("") }

        val isEmailValid by derivedStateOf {
            Patterns.EMAIL_ADDRESS.matcher(emailValue.value).matches()
        }

        val isPasswordValid by derivedStateOf {
            passValue.value.length > 7
        }

        var isPasswordVisible = remember {
            mutableStateOf( false)
        }
        Column(modifier = Modifier.padding(35.dp)) {
            titulo_texto(text = "REGISTRATE")
            TextSubTitleBase("- Nombre de Usuario -")
            Spacer(modifier = Modifier.padding(5.dp))
            caja_texto("Correo",emailValue,isEmailValid)
            caja_clave("Contraseña", passValue,isPasswordVisible,isPasswordValid)
            Spacer(modifier = Modifier.padding(10.dp))

            Spacer(modifier = Modifier.padding(10.dp))
            ButtonOnClickRegister("Registrarse",emailValue,passValue,navController,codProduct)

            Spacer(modifier = Modifier.height(280.dp))
        }



    }
}

@Composable
fun ButtonOnClickRegister(
    text: String,
    emailValue: MutableState<String>,
    passValue: MutableState<String>,
    navController: NavController,
    codProduct: MutableState<String>
) {
    val auth = Firebase.auth
    val context = LocalContext.current


    var active = rememberSaveable {
        mutableStateOf(false)
    }
    //stateSave(active,codProduct.value)
    Button(
        onClick = {

                auth.createUserWithEmailAndPassword(emailValue.value,passValue.value)
                    .addOnCompleteListener{
                        if (it.isSuccessful) {
                            //
                            Toast.makeText(context, "Registro exitoso...",
                                Toast.LENGTH_SHORT).show()
                            navController.navigate("login_page"){
                                popUpTo("register_page"){
                                    inclusive = true
                                }
                            }


                        } else {
                            //
                            Toast.makeText(context, "Sus datos de usuario son incorrectos, intente nuevamente!!",
                                Toast.LENGTH_SHORT).show()
                        }

                    }



        },
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(0.dp, 7.dp),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.Yellow,
            contentColor = Color(0xFF174378)
        )
    ) {
        Text(text = text)
    }
}
