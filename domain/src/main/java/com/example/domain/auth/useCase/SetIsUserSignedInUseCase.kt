package com.blogspot.soyamr.domain.auth.usecase

import com.example.domain.auth.AuthRepository


interface SetIsUserSignedInUseCase {
    suspend fun invoke(isUserSignedIn: Boolean)
}

class SetIsUserSignedInUseCaseImpl(
    private val authRepository: AuthRepository
) : SetIsUserSignedInUseCase {
    override suspend fun invoke(isUserSignedIn: Boolean) = authRepository.setIsUserSignedIn(isUserSignedIn)
}
