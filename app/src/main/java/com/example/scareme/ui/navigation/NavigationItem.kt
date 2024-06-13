package com.example.scareme.ui.navigation

sealed class NavigationItem(val route: String) {
    data object Start : NavigationItem(Screen.START.name)
    data object SignIn : NavigationItem(Screen.SIGN_IN.name)
    data object SignUp : NavigationItem(Screen.SIGN_UP.name)
    data object Home : NavigationItem(Screen.Main.name)
}