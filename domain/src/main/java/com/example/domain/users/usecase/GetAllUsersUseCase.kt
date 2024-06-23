package com.example.domain.users.usecase

import com.example.domain.users.UserRepository
import com.example.domain.users.model.User

interface GetAllUsersUseCase {
    suspend operator fun invoke():List<User>
}

class GetAllUsersUseCaseImpl(
    private val  userRepository: UserRepository
):GetAllUsersUseCase{
    override suspend fun invoke(): List<User> =userRepository.getAllUsers()
}