package com.example.domain.chat

import com.example.domain.chat.model.ChatItem

interface ChatRemoteDataSource {
    suspend fun getChatList(): List<ChatItem>
}
