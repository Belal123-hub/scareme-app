package com.example.domain.chat

import com.example.domain.chat.model.Chat
import com.example.domain.chat.model.ChatItem

interface ChatRemoteDataSource {
    suspend fun getChatList(): List<ChatItem>
     suspend fun createChat(userId: String): Chat

}
