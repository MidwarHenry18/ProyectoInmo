package com.example.inmovapp.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.inmovapp.modelo.menuItem
import com.example.inmovapp.vistas.*


@Composable
fun navegation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "ruta_carga",
        builder = {
            composable("ruta_carga", content = { Pantalla_carga(navController = navController) })
            composable("ruta_mensaje", content = { Pantalla_mensaje(navController = navController) })
            composable("ruta_login", content = { Pantalla_login(navController = navController) })
            composable("ruta_registro", content = { Pantalla_registro(navController = navController) })
            composable("ruta_iniciamenu", content = { Iniciar_menu(navController) })
        }
    )

}
@Composable
fun menu_navegacion(navController: NavHostController, navInit: NavController){
    NavHost(
        navController = navController,
        startDestination = menuItem.inicio.route,
        builder = {
            composable(route = menuItem.inicio.route){ Pantalla_Home(navController,navInit) }
            composable(route = menuItem.buscar.route){ Pantalla_buscar(navController,navInit) }
            composable(route = menuItem.contacto.route){ Pantalla_contacto(navController,navInit) }
            composable(route = menuItem.configuracion.route){ Pantalla_configuracion(navController,navInit) }
            composable(route = "pantalla_ajuste"){ Pantalla_ajuste(navController,navInit) }
            composable(route = "pantalla_detalle"){ manual_uso(navController) }

        }
    )
}