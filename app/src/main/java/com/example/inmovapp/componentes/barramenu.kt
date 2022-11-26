package com.example.inmovapp.componentes

import androidx.compose.foundation.background
import androidx.compose.material.BottomNavigation
import android.icu.math.MathContext
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.inmovapp.modelo.menuItem
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun Barra_navegacion(navController: NavController, items:List<menuItem>){
    val routeActual = routeActual(navController)
    BottomNavigation(
        modifier = Modifier
            .background(Color(0xFF174378))
    ) {
        items.forEach{ screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = screen.title,
                        tint = Color.White
                    )
                },
                label = {
                    Text(text = screen.title)
                },
                selected = routeActual == screen.route,
                onClick = {
                    navController.navigate(screen.route){
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                },
                alwaysShowLabel = false
            )
        }
    }
}
@Composable
fun routeActual(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}