package com.example.domain.chat

import com.example.domain.chat.model.Chat
import com.example.domain.chat.model.ChatItem
import com.example.domain.chat.model.Message
interface ChatRepository {
    suspend fun getChatList(): List<ChatItem>
    suspend fun createChat(userId: String): Chat

}

class ChatRepositoryImpl(
    private val remoteDataSource: ChatRemoteDataSource
) : ChatRepository {
    override suspend fun getChatList(): List<ChatItem> = remoteDataSource.getChatList()
    override suspend fun createChat(userId: String): Chat = remoteDataSource.createChat(userId)}




