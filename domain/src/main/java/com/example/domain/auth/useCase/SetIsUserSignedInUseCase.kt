package com.example.domain.auth.useCase

import com.example.domain.auth.AuthRepository


interface SetIsUserSignedInUseCase {
    suspend fun invoke(isUserSignedIn: Boolean)
}

class SetIsUserSignedInUseCaseImpl(
    private val authRepository: AuthRepository
) : SetIsUserSignedInUseCase {
    override suspend fun invoke(isUserSignedIn: Boolean) = authRepository.setIsUserSignedIn(isUserSignedIn)
}
