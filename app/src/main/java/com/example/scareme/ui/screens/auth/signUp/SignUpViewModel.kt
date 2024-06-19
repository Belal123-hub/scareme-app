package com.example.scareme.ui.screens.auth.signUp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.domain.auth.useCase.SignUpUseCase
import com.example.domain.auth.useCase.model.AuthInfo
import com.example.scareme.ScareMeApplication
import kotlinx.coroutines.launch

class SignUpViewModel(
   private val signUpUseCase: SignUpUseCase
) : ViewModel(){
   fun  signUp(email:String,password:String){
       viewModelScope.launch {
           runCatching { signUpUseCase(authInfo = AuthInfo(email, password)) }
               .onFailure { throwable -> println("Error: ${throwable.message}") }
               .onSuccess { println("Success") }
       }

   }
}