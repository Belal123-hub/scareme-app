package com.example.data.network.chat

import android.util.Log
import com.example.data.network.chat.model.ChatItemResponse
import com.example.domain.chat.ChatRemoteDataSource
import com.example.domain.chat.model.Chat
import com.example.domain.chat.model.ChatItem
import com.example.domain.chat.model.Message
import com.example.domain.chat.model.User

class ChatRemoteDataSourceImpl(
    private val chatApi: ChatApi
) : ChatRemoteDataSource {

    override suspend fun getChatList(): List<ChatItem> {
        return chatApi.getChatList().map { response ->
            Log.d("ChatListViewModel", "Mapping API response: $response")
            ChatItem(
                chat = Chat(
                    id = response.chat.id,
                    title = response.chat.title,
                    avatar = response.chat.avatar
                ),
                lastMessage = Message(
                    id = response.lastMessage.id,
                    text = response.lastMessage.text,
                    createdAt = response.lastMessage.createdAt,
                    user = User(
                        userId = response.lastMessage.user.userId,
                        name = response.lastMessage.user.name,
                        aboutMyself = response.lastMessage.user.aboutMyself,
                        avatar = response.lastMessage.user.avatar
                    ),
                    attachments = response.lastMessage.attachments
                )
            )
        }
    }

}
