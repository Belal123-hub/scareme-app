package com.example.domain.users

import com.example.domain.users.model.User

interface UserRemoteDataSource {
    suspend fun getAllUsers():List<User>
}