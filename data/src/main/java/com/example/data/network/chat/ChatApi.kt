package com.example.data.network.chat

import com.example.data.network.chat.model.ChatItemResponse
import com.example.data.network.chat.model.ChatResponse
import com.example.data.network.chat.model.CreateChatRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ChatApi {
    @GET("v1/chat")
    suspend fun getChatList(): List<ChatItemResponse>
    @POST("v1/chat")
    suspend fun createChat(@Body request: CreateChatRequest): ChatResponse
}
