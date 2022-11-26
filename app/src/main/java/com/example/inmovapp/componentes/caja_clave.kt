package com.example.inmovapp.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun caja_clave(
    text:String,
    password:MutableState<String>,
    isPasswordVisible:MutableState<Boolean>,
    isPasswordValid:Boolean
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 5.dp),
        value = password.value,
        onValueChange = {password.value = it },
        label = { Text("Contraseña")},
        singleLine = true,
        placeholder = { Text(text = "Escriba tu contraseña") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Green,
            unfocusedBorderColor = Color.Yellow,
            cursorColor = Color.Cyan,
            textColor = Color.Yellow,
            disabledTextColor=Color.Red,
            unfocusedLabelColor= Color.Yellow,
            focusedLabelColor = Color.White,
            placeholderColor = Color.White
        ),

        isError = !isPasswordValid,
        trailingIcon = {
            IconButton(
                onClick = { isPasswordVisible.value = !isPasswordVisible.value }
            ) {
                Icon(
                    imageVector = if(isPasswordVisible.value) Icons.Default.Visibility
                    else Icons.Default.VisibilityOff,
                    contentDescription = "Ver Clave",
                    tint = Color.Yellow
                )
            }
        },
        visualTransformation = if(isPasswordVisible.value) VisualTransformation.None
        else PasswordVisualTransformation()
    )

}