package com.example.scareme.ui.screens.message.chatList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.chat.model.ChatItem
import com.example.domain.chat.usecase.GetChatListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ChatListViewModel(
    private val getChatListUseCase: GetChatListUseCase
) : ViewModel() {

    private val _chatList = MutableStateFlow<List<ChatItem>>(emptyList())
    val chatList: StateFlow<List<ChatItem>> get() = _chatList

    init {
        fetchChatList()
    }

    private fun fetchChatList() {
        viewModelScope.launch {
            runCatching {
                getChatListUseCase()
            }.onSuccess { chats ->
                _chatList.value = chats
                Log.d("ChatListViewModel", "Fetched chat list: $chats")
            }.onFailure { throwable ->
                Log.e("ChatListViewModel", "Error fetching chat list: ${throwable.message}")
            }
        }
    }
}
