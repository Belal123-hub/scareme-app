package com.example.domain.chat

import com.example.domain.chat.model.ChatItem

interface ChatRepository {
    suspend fun getChatList(): List<ChatItem>
}

class ChatRepositoryImpl(
    private val remoteDataSource: ChatRemoteDataSource
) : ChatRepository {
    override suspend fun getChatList(): List<ChatItem> = remoteDataSource.getChatList()
}
