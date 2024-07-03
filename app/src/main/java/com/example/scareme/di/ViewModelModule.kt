package com.example.scareme.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.example.scareme.ui.screens.auth.signIn.SignInViewModel
import com.example.scareme.ui.screens.auth.signUp.SignUpViewModel
import com.example.scareme.ui.screens.main.MainScreenViewModel
import com.example.scareme.ui.screens.profile.profileEdit.ProfileEditViewModel
import com.example.scareme.ui.screens.profile.profileInfo.ProfileInfoViewModel
import com.example.scareme.ui.screens.message.chatList.ChatListViewModel
import com.example.scareme.ui.screens.message.chat.ChatViewModel
import com.example.scareme.ui.screens.splash.SplashViewModel

val viewModelModule  = module {
    viewModelOf(::SplashViewModel)
    viewModelOf(::SignInViewModel)
    viewModelOf(::SignUpViewModel)
    viewModelOf(::MainScreenViewModel)
    viewModelOf(::ProfileEditViewModel)
    viewModelOf(::ProfileInfoViewModel)
    viewModelOf(::ChatViewModel)
    viewModelOf(::ChatListViewModel)
}
