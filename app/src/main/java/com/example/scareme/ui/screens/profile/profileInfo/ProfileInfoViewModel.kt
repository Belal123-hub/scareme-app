package com.example.scareme.ui.screens.profile.profileInfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.profile.model.Profile
import com.example.domain.profile.usecase.GetProfileUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProfileInfoViewModel(
    private val getProfileUseCase: GetProfileUseCase
):ViewModel() {
    private val _profile = MutableStateFlow<Profile?>(null)
    val profile = _profile.asStateFlow()

    init {
        getProfile()
    }

    private fun getProfile() {
        viewModelScope.launch {
            runCatching { getProfileUseCase() }
                .onFailure { throwable -> println("Error: ${throwable.message}") }
                .onSuccess { profile ->
                    _profile.value = profile
                }
        }
    }
}