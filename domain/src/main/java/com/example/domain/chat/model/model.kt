package com.example.domain.chat.model


data class Chat(
    val id: String,
    val title: String,
    val avatar: String?
)

data class User(
    val userId: String,
    val name: String,
    val aboutMyself: String?,
    val avatar: String?
)

data class Message(
    val id: String,
    val text: String,
    val createdAt: String,
    val user: User,
    val attachments: List<Any> // Adjust type based on your actual attachment model
)

data class ChatItem(
    val chat: Chat,
    val lastMessage: Message
)
