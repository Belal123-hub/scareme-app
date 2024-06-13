package com.example.domain.auth.useCase

import com.example.domain.auth.AuthRepository


interface SignInUseCase {
    suspend fun invoke()
}

class SignInUseCaseImpl(private val authRepository: AuthRepository) : SignInUseCase {
    override suspend fun invoke() = authRepository.signIn()
}