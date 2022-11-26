package com.example.inmovapp.vistas


import android.content.Context
import android.content.SharedPreferences
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.inmovapp.R
import com.example.inmovapp.componentes.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

private val auth by lazy { Firebase.auth }

@Composable
fun Pantalla_login(navController: NavController){
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()

    // Value EditTexts
    var email = remember { mutableStateOf("") }
    var password = rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    // Validar datos
    val isEmailValid by derivedStateOf {Patterns.EMAIL_ADDRESS.matcher(email.value).matches()}
    val isPasswordValid by derivedStateOf {password.value.length > 7}
    var isPasswordVisible = remember {mutableStateOf( false)}
    Box(modifier = Modifier.fillMaxSize().background(Color(0xFF174378))){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 40.dp)
                .verticalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .padding(horizontal = 100.dp, vertical = 30.dp),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = ""
                )
            }
            titulo_texto(text = "INICIAR SESIÓN")
            caja_texto("Correo",email,isEmailValid)
            caja_clave("Contraseña", password,isPasswordVisible,isPasswordValid)
            TextButtonRecPass("")
            ButtonOnClickLoad("Iniciar Sesión", navController,email,password)
            Spacer(modifier = Modifier.height(100.dp))
            TextButtonRegister("",navController)
            Spacer(modifier = Modifier.height(160.dp))
        }
    }

}

@Composable
fun ButtonOnClickLoad(
    s: String,
    navController: NavController,
    email: MutableState<String>,
    password: MutableState<String>
) {
    var counter by remember { mutableStateOf(1) }
    var isLoading by remember { mutableStateOf(false)}
    val context = LocalContext.current

    if(isLoading){
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            CircularProgressIndicator()
        }

        if (counter == 100){
            counter=1
            isLoading = false
            /*scope.launch {
                dataStore.saveEmail(email)
            }*/
            auth.signInWithEmailAndPassword(email.value,password.value)
                .addOnCompleteListener{
                    if (it.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(context, "Autenticación exitosa.",
                            Toast.LENGTH_SHORT).show()

                        val save: SharedPreferences = context.getSharedPreferences("----", Context.MODE_PRIVATE)
                        val editor:SharedPreferences.Editor = save.edit()
                        editor.putString("id_key",email.value)
                        editor.putString("clave","contraseña")
                        editor.apply()

                        navController.navigate("ruta_iniciamenu"){
                            popUpTo("ruta_login"){
                                inclusive = true
                            }
                        }


                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(context, "Autentication failed.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
            //Guardado de datos

        }
        counter++
    }else{
        Button(
            onClick = { isLoading = true},
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(0.dp, 10.dp),
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.Yellow,
                contentColor = Color(0xFF174378)
            ),
            contentPadding = PaddingValues(horizontal = 8.dp)
            //enabled = isEmailValid && isPasswordValid
        ) {
            Text(
                text = "Iniciar Sesión",
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF174378),
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun TextButtonRegister(text: String,navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = "Aun no tiene cuenta?",
            color = Color.Yellow,
        )
        Text(
            text = " Registrese",
            color = Color.Magenta,
            modifier = Modifier
                .clickable(
                    onClick = {
                        navController.navigate("ruta_registro"){
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                        }
                    }
                )
        )
    }

}

@Composable
fun TextButtonRecPass(text: String) {
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TextButton(
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = text,
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colors.primary,
                modifier = Modifier.padding(end = 4.dp)
            )
        }
    }

}