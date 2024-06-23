package com.example.data.network.profile

import com.example.data.network.profile.model.ProfileResponse
import com.example.data.network.profile.model.TopicResponse
import com.example.data.network.profile.model.UpdateProfileRequestDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.PUT

interface ProfileApi {
    @GET("v1/topic")
    suspend fun getAllTopics(): List<TopicResponse>
    @PATCH("v1/profile")
    suspend fun updateProfile(@Body request: UpdateProfileRequestDto)
    @GET("v1/profile")
    suspend fun getProfile(): ProfileResponse
}