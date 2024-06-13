package com.blogspot.soyamr.domain.auth.usecase

import com.example.domain.auth.AuthRepository


interface SignUpUseCase {
    suspend fun invoke()
}

class SignUpUseCaseImpl(private val authRepository: AuthRepository) : SignUpUseCase {
    override suspend fun invoke() = authRepository.signUp()
}
