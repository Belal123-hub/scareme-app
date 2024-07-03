package com.example.data.network.chat

import com.example.data.network.chat.model.ChatItemResponse
import com.example.data.network.chat.model.ChatResponse
import com.example.data.network.chat.model.CreateChatRequest
import com.example.data.network.chat.model.MessageResponseDto
import com.example.data.network.chat.model.SendMessageRequestDto
import com.example.domain.chat.model.Message
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ChatApi {
    @GET("v1/chat")
    suspend fun getChatList(): List<ChatItemResponse>
    @POST("v1/chat")
    suspend fun createChat(@Body request: CreateChatRequest): ChatResponse
    @POST("v1/chat/{chatId}/message")
    suspend fun sendMessage(
        @Path("chatId") chatId: String,
        @Body request: SendMessageRequestDto
    ): MessageResponseDto

}
