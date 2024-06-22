package com.example.data.network.profile.model

import kotlinx.serialization.Serializable

@Serializable
data class UpdateProfileRequestDto(
    val name: String,
    val aboutMyself: String?,
    val topics: List<String>?
)