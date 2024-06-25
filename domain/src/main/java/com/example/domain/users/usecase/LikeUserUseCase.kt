package com.example.domain.users.usecase

import com.example.domain.users.UserRepository

interface LikeUserUseCase {
    suspend operator fun invoke(userId: String)
}

class LikeUserUseCaseImpl(
    private val userRepository: UserRepository
) : LikeUserUseCase {
    override suspend fun invoke(userId: String) = userRepository.likeUser(userId)
}