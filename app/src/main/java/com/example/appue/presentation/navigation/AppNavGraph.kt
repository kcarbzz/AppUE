package com.kcarbzz.appue.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

// Importa las pantallas
import com.kcarbzz.appue.presentation.home.PlaylistScreen
import com.kcarbzz.appue.presentation.auth.RegisterScreen

// 1. Rutas de la Aplicación
object AppScreens {
    const val AUTH_ROUTE = "auth_route"
    const val REGISTER_ROUTE = "register_route"
    const val HOME_ROUTE = "home_route" // La nueva ruta de inicio (Spotify UI)
}

@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String // La ruta inicial (ej: AUTH_ROUTE si no ha iniciado sesión)
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        
        // === 1. Ruta de Registro ===
        composable(route = AppScreens.REGISTER_ROUTE) {
            RegisterScreen(
                onSuccessfulRegistration = {
                    // Navega a la nueva pantalla HOME (Spotify UI)
                    navController.navigate(AppScreens.HOME_ROUTE) { 
                        // Limpiamos la pila de navegación
                        popUpTo(AppScreens.REGISTER_ROUTE) { inclusive = true } 
                    }
                }
            )
        }
        
        // ** (AÑADE AQUÍ TU RUTA DE LOGIN) **

        // === 2. Ruta HOME (Pantalla Principal de Spotify) ===
        composable(route = AppScreens.HOME_ROUTE) {
            PlaylistScreen() 
        }
    }
}
