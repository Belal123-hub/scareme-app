package com.example.domain.auth.useCase

import com.example.domain.accessToken.AccessTokenRepository
import com.example.domain.auth.AuthRepository


interface SignOutUseCase {
    suspend operator fun invoke()
}

class SignOutUseCaseImpl(
    private val authRepository: AuthRepository,
    private val tokenRepository: AccessTokenRepository
) : SignOutUseCase {
    override suspend fun invoke() {
        authRepository.signOut()
        tokenRepository.setAccessToken(null)
        tokenRepository.setRefreshToken(null)
    }
}
