package com.example.domain.users

import com.example.domain.users.model.User

interface UserRemoteDataSource {
    suspend fun getAllUsers():List<User>
    suspend fun likeUser(userId: String)

    suspend fun dislikeUser(userId: String)
}