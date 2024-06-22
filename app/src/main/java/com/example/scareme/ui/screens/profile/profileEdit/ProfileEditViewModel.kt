package com.example.scareme.ui.screens.profile.profileEdit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.auth.useCase.SignOutUseCase
import com.example.domain.profile.model.Topic
import com.example.domain.profile.model.UpdateProfileRequest
import com.example.domain.profile.usecase.GetAllTopicsUseCase
import com.example.domain.profile.usecase.UpdateProfileUseCase
import com.example.scareme.ui.screens.profile.profileEdit.model.TopicUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProfileEditViewModel(
  //  private val signOutUseCase: SignOutUseCase,
    private val updateProfileUseCase: UpdateProfileUseCase,
    private val getAllTopicsUseCase: GetAllTopicsUseCase
):ViewModel() {

    private val _topics = MutableStateFlow(emptyList<TopicUi>())
    val topics = _topics.asStateFlow()

    private val _updateStatus = MutableStateFlow<Result<Unit>?>(null)
    val updateStatus = _updateStatus.asStateFlow()


    init {
        getAllTopics()
    }

    fun onTopicSelected(topicId: String) {
        _topics.value = _topics.value.map { topic ->
            if (topic.id == topicId) {
                topic.copy(isSelected = !topic.isSelected)
            } else {
                topic
            }
        }
    }

    private fun getAllTopics() {
        viewModelScope.launch {
            runCatching { getAllTopicsUseCase() }
                .onFailure { throwable -> println("Error: ${throwable.message}") }
                .onSuccess { topics ->
                    _topics.value = topics.map { topic: Topic ->
                        TopicUi(
                            id = topic.id,
                            title = topic.title
                        )
                    }
                }
        }
    }

    fun updateProfile(name: String, aboutMyself: String, topics: List<String>) {
        viewModelScope.launch {
            val request = UpdateProfileRequest(name, aboutMyself, topics)
            updateProfileUseCase(request)
           // _updateStatus.value = result
        }
    }

//    fun signOut() {
//        viewModelScope.launch {
//            runCatching { signOutUseCase() }
//                .onFailure { throwable -> println("Error: ${throwable.message}") }
//                .onSuccess { println("Success") }
//        }
//    }
}