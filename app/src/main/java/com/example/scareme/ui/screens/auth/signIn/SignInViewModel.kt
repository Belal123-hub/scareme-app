package com.example.scareme.ui.screens.auth.signIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.domain.auth.useCase.SignInUseCase
import com.example.domain.auth.useCase.model.AuthInfo
import com.example.scareme.ScareMeApplication
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class SignInViewModel(
    private val signInUseCase: SignInUseCase
) : ViewModel(){
    private val _navigateToMain=MutableSharedFlow<Unit>()
    val navigateToMain=_navigateToMain.asSharedFlow()

    private val _showError = MutableSharedFlow<String>()
    val showError = _showError.asSharedFlow()

    fun signIn(email: String , password: String ) {

        viewModelScope.launch {
            runCatching { signInUseCase(authInfo = AuthInfo(email, password)) }
                .onFailure {throwable ->
                    _showError.emit(throwable.message.orEmpty())                    // if not then error

                }
                .onSuccess {
                    _navigateToMain.emit(Unit)

                }
        }
    }

}