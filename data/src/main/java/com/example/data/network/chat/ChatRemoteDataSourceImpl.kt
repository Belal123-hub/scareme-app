package com.example.data.network.chat

import com.example.data.network.chat.model.AttachmentResponse
import com.example.data.network.chat.model.CreateChatRequest
import com.example.data.network.chat.model.SendMessageRequestDto
import com.example.data.network.chat.model.UserResponse
import com.example.domain.chat.ChatRemoteDataSource
import com.example.domain.chat.model.Chat
import com.example.domain.chat.model.ChatItem
import com.example.domain.chat.model.Message
import com.example.domain.chat.model.User
import com.example.domain.chat.model.Attachment // Ensure this import is correct

class ChatRemoteDataSourceImpl(
    private val chatApi: ChatApi
) : ChatRemoteDataSource {

    override suspend fun getChatList(): List<ChatItem> {
        return chatApi.getChatList().map { response ->
            ChatItem(
                chat = Chat(
                    id = response.chat.id,
                    title = response.chat.title,
                    avatar = response.chat.avatar
                ),
                lastMessage = response.lastMessage?.id?.let {
                    Message(
                        id = it,
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
                }
            )
        }
    }

    override suspend fun createChat(userId: String): Chat {
        val request = CreateChatRequest(userId)
        val response = chatApi.createChat(request)
        return Chat(
            id = response.id,
            title = response.title,
            avatar = response.avatar
        )
    }








}
