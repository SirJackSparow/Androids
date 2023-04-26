package com.example.androids.utils

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androids.ui.login.LoginScreen
import com.example.androids.ui.otp.OtpScreen
import com.example.androids.ui.register.RegisterScreen

@Composable
fun NavHostComponent(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            LoginScreen(navController)
        }
        composable(Screen.Register.route) {
            RegisterScreen(navController)
        }
        composable(Screen.Otp.route){
            OtpScreen(navController)
        }
    }
}

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object Otp : Screen("otp")
}
