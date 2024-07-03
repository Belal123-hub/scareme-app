package com.example.scareme.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.scareme.ui.screens.auth.signIn.SignInScreen
import com.example.scareme.ui.screens.auth.signUp.SignUpScreen
import com.example.scareme.ui.screens.auth.start.StartScreen
import com.example.scareme.ui.screens.main.MainScreen
import com.example.scareme.ui.screens.message.chatList.ChatListScreen
import com.example.scareme.ui.screens.profile.profileEdit.ProfileEditScreen
import com.example.scareme.ui.screens.profile.profileEdit.ProfileEditViewModel
import com.example.scareme.ui.screens.profile.profileInfo.ProfileInfoScreen
import com.example.scareme.ui.screens.splash.LaunchScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            val screensWithoutBottomNav = listOf(
                NavigationItem.Splash.route,
                NavigationItem.Start.route,
                NavigationItem.SignIn.route,
                NavigationItem.SignUp.route,
                NavigationItem.ProfileEdit.route

            )
            if (currentDestination?.route in screensWithoutBottomNav) {
                return@Scaffold
            }

            BottomNavigationBar(
                currentRoute = NavigationItem.findByRoute(currentDestination?.route)
            ) { navigationItem ->
                navController.navigate(navigationItem.route)
            }
        }
    ) { innerPadding ->
        NavHost(
            modifier = modifier.padding(innerPadding),
            navController = navController,
            startDestination = NavigationItem.Splash.route
        ) {
            composable(NavigationItem.Splash.route) {
                LaunchScreen { navItem ->
                    //navController.navigate(navItem.route)
                    navController.navigate(NavigationItem.Start.route)

                }
            }

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
                val viewModel = koinViewModel<ProfileEditViewModel>()
                ProfileEditScreen(
                    profile = viewModel.profile, // Pass the profile data
                    onSignInSuccess = {
                        navController.navigate(NavigationItem.Home.route)
                    })
            }

            composable(NavigationItem.SignIn.route) {
                SignInScreen(
                    onSignInSuccess = {
                        navController.navigate(NavigationItem.Home.route)
                    }
                )
            }

            composable(NavigationItem.Home.route) {
                MainScreen()
            }

            composable(NavigationItem.ProfileInfo.route) {
                ProfileInfoScreen(
                    onEditProfile = {
                        navController.navigate(NavigationItem.ProfileEdit.route)
                    }
                )
            }

            composable(NavigationItem.ChatList.route) {
                ChatListScreen()
            }

            composable(NavigationItem.Chat.route) {
                //ChatScreen()
            }
        }
    }
}