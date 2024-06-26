package com.example.scareme.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.users.usecase.DislikeUserUseCase
import com.example.domain.users.usecase.GetAllUsersUseCase
import com.example.domain.users.usecase.LikeUserUseCase
import com.example.scareme.ui.screens.main.model.Topic
import com.example.scareme.ui.screens.main.model.UserUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val getAllUsersUseCase: GetAllUsersUseCase,
    private val likeUserUseCase: LikeUserUseCase,
    private val dislikeUserUseCase: DislikeUserUseCase
) : ViewModel() {
    private val _users = MutableStateFlow(emptyList<UserUi>())
    val users = _users.asStateFlow()

    private val _isRequestInProgress = MutableStateFlow(false)
    val isRequestInProgress = _isRequestInProgress

    // Map to store the liked state of users
    private val likedUsersMap = mutableMapOf<String, Boolean>()

    init {
        fetchAllUsers()
    }

    private fun fetchAllUsers() {
        viewModelScope.launch {
            runCatching { getAllUsersUseCase() }
                .onFailure { throwable -> println("Error: ${throwable.message}") }
                .onSuccess { users ->
                    _users.value = users.map { user ->
                        UserUi(
                            userId = user.userId,
                            name = user.name,
                            aboutMyself = user.aboutMyself,
                            avatar = user.avatar,
                            topics = user.topics.map { topic ->
                                Topic(
                                    id = topic.id,
                                    title = topic.title
                                )
                            },
                            isLiked = likedUsersMap[user.userId] ?: false  // Use the map to get the liked state
                        )
                    }
                }
        }
    }

    fun likeUser(userId: String) {
        if (_isRequestInProgress.value) return

        viewModelScope.launch {
            _isRequestInProgress.value = true
            runCatching { likeUserUseCase(userId) }
                .onFailure { throwable -> println("Error: ${throwable.message}") }
                .onSuccess {
                    println("Liked user: $userId")
                    likedUsersMap[userId] = true
                   // fetchAllUsers()
                }
            fetchAllUsers()
            _isRequestInProgress.value = false
        }
    }

    fun dislikeUser(userId: String) {
        if (_isRequestInProgress.value) return

        viewModelScope.launch {
            _isRequestInProgress.value = true
            runCatching { dislikeUserUseCase(userId) }
                .onFailure { throwable -> println("Error: ${throwable.message}") }
                .onSuccess {
                    println("Disliked user: $userId")
                    likedUsersMap[userId] = false
                    //fetchAllUsers()
                }
            fetchAllUsers()
            _isRequestInProgress.value = false
        }
    }
}
