package com.example.androids.utils

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.androids.ui.login.LoginScreen
import com.example.androids.ui.otp.OtpScreen
import com.example.androids.ui.register.RegisterScreen

@Composable
fun NavHostComponent(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Login.route) {
        composable(route = Screen.Login.route) {
            LoginScreen(navController)
        }
        composable(Screen.Register.route) {
            RegisterScreen(navController)
        }
        composable(
            route = Screen.Otp.route + "/{number}",
            arguments = listOf(navArgument("number"){
                type = NavType.StringType
                defaultValue = "233"
                nullable = true
            })
        ) {entry ->
            OtpScreen(navController,entry.arguments?.getString("number"))
        }
    }
}

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object Otp : Screen("otp")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {args ->
                append("/$args")
            }
        }
    }
}
