package com.example.data.network.users

import com.example.data.network.users.model.UserResponse
import retrofit2.http.GET

interface UserApi{
    @GET("v1/user/feed")
    suspend fun getAllUsers():List<UserResponse>

}