package com.example.domain.profile

import com.example.domain.profile.model.Profile
import com.example.domain.profile.model.Topic
import com.example.domain.profile.model.UpdateProfileRequest

interface ProfileRemoteDataSource {
    suspend fun getAllTopics(): List<Topic>
    suspend fun updateProfile(request: UpdateProfileRequest)
    suspend fun getProfile(): Profile

}