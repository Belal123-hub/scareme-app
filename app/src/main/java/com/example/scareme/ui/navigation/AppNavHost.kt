package com.example.scareme.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.scareme.ui.screens.auth.signIn.SignInScreen
import com.example.scareme.ui.screens.auth.signUp.SignUpScreen
import com.example.scareme.ui.screens.auth.start.StartScreen
import com.example.scareme.ui.screens.main.MainScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: NavigationItem,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination.route
    ) {
        composable(NavigationItem.Home.route) {
            MainScreen()
        }
        composable(NavigationItem.SignIn.route) {
            SignInScreen()
        }
        composable(NavigationItem.SignUp.route) {
            SignUpScreen()
        }
        composable(NavigationItem.Start.route) {
            StartScreen(
                onStartClick = { navController.navigate(NavigationItem.SignIn.route) },
                onSignUpClick = { navController.navigate(NavigationItem.SignUp.route) }
            )
        }
    }
}