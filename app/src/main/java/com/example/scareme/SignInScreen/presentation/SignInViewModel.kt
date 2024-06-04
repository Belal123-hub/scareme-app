package com.example.scareme.signUpScreen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.scareme.ScareMeApplication
import com.example.scareme.signInScreen.data.SignInRepository

class SignInViewModel(
   private val signInRepository: SignInRepository
) : ViewModel(){


    companion object{
        val Factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY]  as ScareMeApplication)
                val signInRepository = application.container2.signInRepository
                SignInViewModel(signInRepository = signInRepository)
            }
        }
    }


}