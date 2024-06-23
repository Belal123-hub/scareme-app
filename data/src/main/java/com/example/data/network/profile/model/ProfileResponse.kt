package com.example.data.network.profile.model

import kotlinx.serialization.Serializable

@Serializable
data class ProfileResponse(
    val userId: String,
    val name: String,
    val aboutMyself: String,
    val avatar: String?,
    val topics: List<TopicResponse>
)