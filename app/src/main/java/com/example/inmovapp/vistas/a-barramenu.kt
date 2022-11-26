package com.example.inmovapp.vistas

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.inmovapp.componentes.Barra_navegacion
import com.example.inmovapp.modelo.menuItem
import com.example.inmovapp.navegacion.menu_navegacion

@Composable
fun Iniciar_menu(navController_INIT: NavController) {
    val navControllerMenu = rememberNavController()
    val navItem = listOf(
        menuItem.inicio,
        menuItem.buscar,
        menuItem.contacto,
        menuItem.configuracion
    )

    Scaffold(
        bottomBar = {
            Barra_navegacion(
                navController = navControllerMenu,
                items = navItem
            )
        }
    ){
        menu_navegacion( navControllerMenu, navController_INIT)
    }
}