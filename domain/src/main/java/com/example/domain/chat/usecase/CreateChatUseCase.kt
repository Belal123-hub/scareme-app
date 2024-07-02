package com.example.domain.chat.usecase

import com.example.domain.chat.model.Chat
import com.example.domain.chat.ChatRepository

interface CreateChatUseCase {
    suspend operator fun invoke(userId: String): Chat
}

class CreateChatUseCaseImpl(
    private val chatRepository: ChatRepository
) : CreateChatUseCase {
    override suspend fun invoke(userId: String): Chat = chatRepository.createChat(userId)
}
