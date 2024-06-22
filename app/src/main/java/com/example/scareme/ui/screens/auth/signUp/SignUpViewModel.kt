package com.example.scareme.ui.screens.auth.signUp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.auth.useCase.SignUpUseCase
import com.example.domain.auth.useCase.model.AuthInfo
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {
    private val _navigateToProfileEdit = MutableSharedFlow<Unit>()
    val navigateToProfileEdit = _navigateToProfileEdit.asSharedFlow()

    private val _showError = MutableSharedFlow<String>()
    val showError = _showError.asSharedFlow()

    fun signUp(email: String, password: String, repeatPassword: String) {
        viewModelScope.launch {
            if(password!=repeatPassword){
                _showError.emit("really bro")
                return@launch
            }

            runCatching { signUpUseCase(authInfo = AuthInfo(email, password)) }   // if accessT and refreshT recieved and set
                .onFailure { throwable ->
                    _showError.emit(throwable.message.orEmpty())                    // if not then error
                }
                .onSuccess {
                    _navigateToProfileEdit.emit(Unit)                           // if yes then  navigate next
                }
        }
    }
}


//class SignUpViewModel(
//    private val signUpUseCase: SignUpUseCase,
//    private val getAllTopicsUseCase: GetAllTopicsUseCase
//) : ViewModel() {
//
//    private val _topics = MutableStateFlow(emptyList<TopicUi>())
//    val topics = _topics.asStateFlow()
//
//    fun signUp(email: String, password: String) {
//        viewModelScope.launch {
//            runCatching { signUpUseCase(authInfo = AuthInfo(email, password)) }
//                .onFailure { throwable -> println("Error: ${throwable.message}") }
//                .onSuccess {
//                    println("Success")
//                    getAllTopics()
//                }
//        }
//    }
//
//    private fun getAllTopics() {
//        viewModelScope.launch {
//            runCatching { getAllTopicsUseCase() }
//                .onFailure { throwable -> println("Error: ${throwable.message}") }
//                .onSuccess { topics ->
//                    _topics.value = topics.map { topic ->
//                        TopicUi(
//                            id = topic.id,
//                            title = topic.title
//                        )
//                    }
//                }
//        }
//    }
//}