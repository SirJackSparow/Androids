package com.example.androids.utils

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androids.ui.login.LoginScreen

@Composable
fun NavHostComponent(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            LoginScreen(navController)
        }
        composable(Screen.Profile.route) {
            //ProfileScreen(navController)
        }
        // add additional screens here as needed
    }
}

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile")
    // add additional screens here as needed
}