package com.example.domain.users

import com.example.domain.users.model.User

interface UserRepository{
    suspend fun getAllUsers():List<User>
    suspend fun likeUser(userId: String)
    suspend fun dislikeUser(userId: String)
}
class UserRepositoryImpl(
    private val remoteDataSource: UserRemoteDataSource
):UserRepository{
    override suspend fun getAllUsers(): List<User> = remoteDataSource.getAllUsers()
    override suspend fun likeUser(userId: String) {
        remoteDataSource.likeUser(userId)
    }

    override suspend fun dislikeUser(userId: String) {
        remoteDataSource.dislikeUser(userId)
    }
}