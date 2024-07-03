//package com.example.domain.chat.usecase
//
//import com.example.domain.chat.ChatRepository
//import com.example.domain.chat.model.Message
//
//interface GetChatMessagesUseCase {
//    suspend operator fun invoke(chatId: String): List<Message>
//}
//
//class GetChatMessagesUseCaseImpl(
//    private val chatRepository: ChatRepository
//) : GetChatMessagesUseCase {
//    override suspend fun invoke(chatId: String): List<Message> {
//        return chatRepository.getChatMessages(chatId)
//    }
//}
