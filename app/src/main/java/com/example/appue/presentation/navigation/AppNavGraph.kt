package com.example.appue.presentation.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appue.presentation.auth.LoginScreen
import com.example.appue.presentation.auth.RegisterScreen
import com.example.appue.presentation.home.Welcome

@Composable
fun AppNavGraph(){
    val navController = rememberNavController()


    NavHost(navController = navController,
        startDestination = "register"){
        composable("register"){ RegisterScreen(navController) }
        composable("login"){ LoginScreen(navController) }
        composable("Welcome"){ Welcome(navController) }


    }

}