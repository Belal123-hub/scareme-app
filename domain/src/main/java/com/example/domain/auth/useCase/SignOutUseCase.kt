package com.example.domain.auth.useCase

import com.example.domain.auth.AuthRepository


interface SignOutUseCase {
    suspend fun invoke()
}

class SignOutUseCaseImpl(private val authRepository: AuthRepository) : SignOutUseCase {
    override suspend fun invoke() = authRepository.signOut()
}
