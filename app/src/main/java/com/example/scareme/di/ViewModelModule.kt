package com.example.scareme.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.example.scareme.ui.screens.auth.signIn.SignInViewModel
import com.example.scareme.ui.screens.auth.signUp.SignUpViewModel
val viewModelModule  = module {
    viewModelOf(::SignInViewModel)
    viewModelOf(::SignUpViewModel)
}