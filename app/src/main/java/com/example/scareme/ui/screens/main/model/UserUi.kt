package com.example.scareme.ui.screens.main.model

data class UserUi(
    val userId: String,
    val name: String?,
    val aboutMyself: String?,
    val avatar: String?,
    val topics: List<Topic>
)
