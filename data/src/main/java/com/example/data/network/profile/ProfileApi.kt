package com.example.data.network.profile

import com.blogspot.soyamr.data.network.profile.model.TopicResponse
import retrofit2.http.GET

interface ProfileApi {
    @GET("v1/topic")
    suspend fun getAllTopics(): List<TopicResponse>
}