package com.blogspot.soyamr.domain.auth.usecase

import com.example.domain.auth.AuthRepository


interface SignInUseCase {
    suspend fun invoke()
}

class SignInUseCaseImpl(private val authRepository: AuthRepository) : SignInUseCase {
    override suspend fun invoke() = authRepository.signIn()
}