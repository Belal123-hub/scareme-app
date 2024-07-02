package com.example.scareme.ui.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.auth.useCase.IsUserSignedInUseCase
import com.example.scareme.ui.navigation.NavigationItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class SplashViewModel(
    isUserSignedInUseCase: IsUserSignedInUseCase,
) : ViewModel() {

    val navigateToNextScreen = MutableSharedFlow<NavigationItem>()

    init {
        viewModelScope.launch {
            delay(2000L)
            isUserSignedInUseCase.invoke().collect { isUserSignedIn ->
                if (isUserSignedIn) {
                    navigateToNextScreen.emit(NavigationItem.Home)
                } else {
                    navigateToNextScreen.emit(NavigationItem.Start)
                }
            }
        }
    }
}