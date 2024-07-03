package com.example.data.network.chat.model

import kotlinx.serialization.Serializable

@Serializable
data class SendMessageRequestDto(
    val id: String,
    val text: String,
    val createdAt: String,
    val attachments: List<AttachmentResponse>, // Use AttachmentResponse here
    val user: UserResponse
)
