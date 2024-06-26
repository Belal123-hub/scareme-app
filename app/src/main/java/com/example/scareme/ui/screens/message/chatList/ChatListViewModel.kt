package com.example.scareme.ui.screens.message.chatList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.chat.model.ChatItem
import com.example.domain.chat.usecase.GetChatListUseCase
import com.example.scareme.ui.screens.main.model.UserUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ChatListViewModel(
    private val getChatListUseCase: GetChatListUseCase
) : ViewModel() {


    private val _likedUsers = MutableStateFlow(emptyList<UserUi>())
    val likedUsers = _likedUsers.asStateFlow()

    fun setLikedUsers(users: List<UserUi>) {
        _likedUsers.value = users.filter { it.isLiked }.sortedBy { it.name }
    }

    private val _chatList = MutableStateFlow<List<ChatItem>>(emptyList())
    val chatList: StateFlow<List<ChatItem>> get() = _chatList

    init {
        fetchChatList()
    }

    private fun fetchChatList() {
        viewModelScope.launch {
            val chats = getChatListUseCase()
            _chatList.value = chats
            Log.d("ChatListViewModel", "Fetched chat list: $chats")
        }
    }

}
