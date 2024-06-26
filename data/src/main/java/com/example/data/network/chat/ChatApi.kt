package com.example.data.network.chat

import com.example.data.network.chat.model.ChatItemResponse
import retrofit2.http.GET

interface ChatApi {
    @GET("v1/chat")
    suspend fun getChatList(): List<ChatItemResponse>
}
