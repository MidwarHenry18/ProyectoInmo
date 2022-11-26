package com.example.inmovapp.componentes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun caja_texto(text:String, textValue: MutableState<String>,isEmailValid:Boolean) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 5.dp),
        value = textValue.value,
        singleLine = true,
        onValueChange = {textValue.value = it},
        label = { Text(text = text)},
        placeholder = { Text(text = "Escriba su correo",color = Color.White)},
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Green,
            unfocusedBorderColor = Yellow,
            focusedLabelColor = Color.White,
            cursorColor = Color.Cyan,
            textColor = Color.Yellow,
        disabledTextColor=Color.Red,
            unfocusedLabelColor= Color.Yellow
        ),

        isError = isEmailValid,
        trailingIcon = {
            if (textValue.value.isNotBlank()){
                IconButton(onClick = { textValue.value = "" }) {
                    Icon(imageVector = Icons.Filled.Clear  , contentDescription = "", tint = Color.Yellow)

                }
            }
        }
    )

}