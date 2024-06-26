package com.example.data.network.chat.model

import kotlinx.serialization.Serializable

@Serializable
data class AttachmentResponse(
    val id: String,
    val type: String,
    val url: String
)

@Serializable
data class ChatResponse(
    val id: String,
    val title: String,
    val avatar: String?
)

@Serializable
data class UserResponse(
    val userId: String,
    val name: String,
    val aboutMyself: String?,
    val avatar: String?
)

@Serializable
data class MessageResponse(
    val id: String,
    val text: String,
    val createdAt: String,
    val user: UserResponse,
    val attachments: List<AttachmentResponse>
)

@Serializable
data class ChatItemResponse(
    val chat: ChatResponse,
    val lastMessage: MessageResponse
)
