package com.example.domain.users.model

import com.example.domain.profile.model.Topic

data class User(
    val userId: String,
    val name: String?,
    val aboutMyself: String?,
    val avatar: String?,
    val topics: List<Topic>
)