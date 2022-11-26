package com.example.inmovapp.modelo


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class menuItem(
    val  route: String,
    val title:String,
    val icon: ImageVector
) {
    object inicio:menuItem(
        "opcion_inicio",
        "Home",
        Icons.Filled.Home
    )
    object buscar:menuItem(
        "opcion_busqueda",
        "Buscar",
        Icons.Filled.Search
    )
    object contacto:menuItem(
        "opcion_contacto",
        "Contacto",
        Icons.Filled.Call
    )
    object configuracion:menuItem(
        "opcion_configuracion",
        "Ajustes",
        Icons.Filled.Settings
    )
}