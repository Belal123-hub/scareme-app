package com.example.domain.profile.model

data class Profile(
    val userId: String,
    val name: String,
    val aboutMyself: String,
    val avatar: String?,
    val topics: List<Topic>
)