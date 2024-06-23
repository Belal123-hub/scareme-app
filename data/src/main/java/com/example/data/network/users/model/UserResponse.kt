package com.example.data.network.users.model

import com.example.data.network.profile.model.TopicResponse
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val userId: String,
    val name: String?,
    val aboutMyself: String?,
    val avatar: String?,
    val topics: List<TopicResponse>
)