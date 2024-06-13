package com.example.domain.auth.useCase

import com.example.domain.auth.AuthRepository


interface SignUpUseCase {
    suspend fun invoke()
}

class SignUpUseCaseImpl(private val authRepository: AuthRepository) : SignUpUseCase {
    override suspend fun invoke() = authRepository.signUp()
}
