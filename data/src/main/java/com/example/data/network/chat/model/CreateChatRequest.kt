package com.example.data.network.chat.model

import kotlinx.serialization.Serializable

@Serializable
data class CreateChatRequest(
    val userId: String
)