package com.example.data.network.chat.model

import com.example.data.network.chat.model.UserResponse
import kotlinx.serialization.Serializable

@Serializable
data class MessageResponseDto(
    val id: String,
    val text: String,
    val createdAt: String,
    val user: UserResponse,
    val attachments: List<AttachmentResponse> // Assuming attachments have the structure defined earlier
)
