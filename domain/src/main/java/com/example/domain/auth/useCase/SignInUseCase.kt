package com.example.domain.auth.useCase

import com.example.domain.auth.AuthRepository
import com.example.domain.auth.useCase.model.AuthInfo


interface SignInUseCase {
    suspend operator fun invoke(authInfo:AuthInfo)
}

class SignInUseCaseImpl(private val authRepository: AuthRepository) : SignInUseCase {
    override suspend fun invoke(authInfo:AuthInfo) = authRepository.signIn(authInfo)
}