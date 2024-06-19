package com.example.domain.auth.useCase

import com.example.domain.auth.AuthRepository
import com.example.domain.auth.useCase.model.AuthInfo


interface SignUpUseCase {
    suspend operator fun invoke(authInfo: AuthInfo)
}

class SignUpUseCaseImpl(private val authRepository: AuthRepository) : SignUpUseCase {
    override suspend fun invoke(authInfo: AuthInfo) = authRepository.signUp(authInfo)
}
