package com.example.data.network.users

import com.example.data.network.users.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserApi{
    @GET("v1/user/feed")
    suspend fun getAllUsers():List<UserResponse>
    @POST("v1/user/{userId}/like")
    suspend fun likeUser(@Path("userId") userId: String)

    @POST("v1/user/{userId}/dislike")
    suspend fun dislikeUser(@Path("userId") userId: String)

}