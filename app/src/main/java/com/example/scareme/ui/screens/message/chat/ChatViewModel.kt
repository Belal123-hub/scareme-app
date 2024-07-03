package com.example.scareme.ui.screens.message.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.chat.model.Message
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ChatViewModel(
 //   private val getChatMessagesUseCase: GetChatMessagesUseCase,
   // private val sendMessageUseCase: SendMessageUseCase
) : ViewModel() {

//    private val _messages = MutableStateFlow<List<Message>>(emptyList())
//    val messages: StateFlow<List<Message>> get() = _messages
//
//    fun fetchMessages(chatId: String) {
//        viewModelScope.launch {
//            runCatching {
//                getChatMessagesUseCase(chatId)
//            }.onSuccess { messages ->
//                _messages.value = messages
//            }.onFailure { throwable ->
//                // Handle error
//            }
//        }
//    }
//
//    fun sendMessage(chatId: String, messageText: String, attachments: List<Any>) {
//        viewModelScope.launch {
//            val request = SendMessageRequest(chatId, messageText, attachments)
//            runCatching {
//                sendMessageUseCase.sendMessage(request)
//            }.onSuccess { message ->
//                _messages.value = listOf(message) + _messages.value
//            }.onFailure { throwable ->
//                // Handle error
//            }
//        }
//    }
}
