package com.example.scareme.mainActivity

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.domain.auth.useCase.IsUserSignedInUseCase

class MainActivityViewModel(
    isUserSignedInUseCase: IsUserSignedInUseCase,
) : ViewModel() {

    val isUserSignedIn = isUserSignedInUseCase.invoke()

    fun signUp() {
        Log.d("HomeViewModel", "signIn")
    }
}