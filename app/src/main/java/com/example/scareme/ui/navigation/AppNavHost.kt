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
import com.example.scareme.ui.screens.message.chat.ChatScreen
import com.example.scareme.ui.screens.message.chatList.ChatListScreen
import com.example.scareme.ui.screens.profile.profileEdit.ProfileEditScreen
import com.example.scareme.ui.screens.profile.profileInfo.ProfileInfoScreen

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
        composable(NavigationItem.Start.route) {
            StartScreen(
                onStartClick = { navController.navigate(NavigationItem.SignIn.route) },
                onSignUpClick = { navController.navigate(NavigationItem.SignUp.route) }
            )
        }

        composable(NavigationItem.SignUp.route) {
            SignUpScreen(
                onSignUpSuccess = {
                    navController.navigate(NavigationItem.ProfileEdit.route)
                }
            )
        }
        composable(NavigationItem.ProfileEdit.route) {
            ProfileEditScreen(
                onSignInSuccess = {navController.navigate(NavigationItem.Home.route)}
            )
        }

        composable(NavigationItem.SignIn.route) {
            SignInScreen(
                onSignInSuccess = {
                   navController.navigate(NavigationItem.Home.route)
               }
            )
        }

        composable(NavigationItem.Home.route) {
            MainScreen(onClick={
                navController.navigate(NavigationItem.Home.route)
            })
        }

        composable(NavigationItem.ProfileInfo.route){
            ProfileInfoScreen()
        }

        composable(NavigationItem.ChatList.route){
            ChatListScreen()
        }

        composable(NavigationItem.Chat.route){
            ChatScreen()
        }
    }
}