//package com.example.domain.chat.usecase
//
//import com.example.domain.chat.ChatRepository
//import com.example.domain.chat.model.Message
//import com.example.domain.chat.model.SendMessageRequest
//
//interface SendMessageUseCase {
//    suspend fun sendMessage(request: SendMessageRequest): Message
//}
//    class SendMessageUseCaseImpl(
//        private val chatRepository: ChatRepository
//    ) : SendMessageUseCase {
//        override suspend fun sendMessage(request: SendMessageRequest): Message {
//            return chatRepository.sendMessage(request)
//        }
//    }
//
