package com.example.domain.users

import com.example.domain.users.model.User

interface UserRepository{
    suspend fun getAllUsers():List<User>
}
class UserRepositoryImpl(
    private val remoteDataSource: UserRemoteDataSource
):UserRepository{
    override suspend fun getAllUsers(): List<User> = remoteDataSource.getAllUsers()
}