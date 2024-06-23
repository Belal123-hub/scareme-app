// ui/screens/users/UsersViewModel.kt
package com.example.scareme.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.users.usecase.GetAllUsersUseCase
import com.example.scareme.ui.screens.main.model.UserUi
import com.example.scareme.ui.screens.main.model.Topic
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val getAllUsersUseCase: GetAllUsersUseCase
) : ViewModel() {
    private val _users = MutableStateFlow(emptyList<UserUi>())
    val users = _users.asStateFlow()

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
                            }
                        )
                    }
                }
        }
    }
}
