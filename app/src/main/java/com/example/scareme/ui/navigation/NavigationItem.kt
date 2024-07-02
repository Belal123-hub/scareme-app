package com.example.scareme.ui.navigation

sealed class NavigationItem(val route: String) {
    data object Splash : NavigationItem(Screen.Splash.name)
    data object Start : NavigationItem(Screen.START.name)
    data object SignIn : NavigationItem(Screen.SIGN_IN.name)
    data object SignUp : NavigationItem(Screen.SIGN_UP.name)
    data object Home : NavigationItem(Screen.Main.name)
    data object ProfileEdit : NavigationItem(Screen.ProfileEdit.name)
    data object ProfileInfo : NavigationItem(Screen.ProfileInfo.name)
    data object ChatList : NavigationItem(Screen.ChatList.name)
    data object Chat : NavigationItem(Screen.Chat.name)

    companion object {
        fun findByRoute(route: String?): NavigationItem? {
            return when (route) {
                Screen.Splash.name -> Splash
                Screen.START.name -> Start
                Screen.SIGN_IN.name -> SignIn
                Screen.SIGN_UP.name -> SignUp
                Screen.Main.name -> Home
                Screen.ProfileEdit.name -> ProfileEdit
                Screen.ProfileInfo.name -> ProfileInfo
                Screen.ChatList.name -> ChatList
                Screen.Chat.name -> Chat
                else -> null
            }
        }
    }
}