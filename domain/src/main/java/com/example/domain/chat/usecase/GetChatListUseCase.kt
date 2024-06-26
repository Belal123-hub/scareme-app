package com.example.domain.chat.usecase

import com.example.domain.chat.ChatRepository
import com.example.domain.chat.model.ChatItem

interface GetChatListUseCase {
    suspend operator fun invoke(): List<ChatItem>
}

class GetChatListUseCaseImpl(
    private val chatRepository: ChatRepository
) : GetChatListUseCase {
    override suspend fun invoke(): List<ChatItem> = chatRepository.getChatList()
}
