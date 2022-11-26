package com.example.inmovapp.componentes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.inmovapp.R
@Composable
fun titulo_texto(text:String){
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 7.dp),
        textAlign = TextAlign.Center,
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        color = androidx.compose.ui.graphics.Color.Yellow
    )
}