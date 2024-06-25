package com.example.domain.users.usecase

import com.example.domain.users.UserRepository

interface DislikeUserUseCase {
    suspend operator fun invoke(userId: String)
}

class DislikeUserUseCaseImpl(
    private val userRepository: UserRepository
) : DislikeUserUseCase {
    override suspend fun invoke(userId: String) = userRepository.dislikeUser(userId)
}