package com.example.domain.profile.model

data class UpdateProfileRequest(
    val name: String,
    val aboutMyself: String?,
    val topics: List<String>?
)