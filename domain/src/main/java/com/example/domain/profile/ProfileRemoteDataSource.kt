package com.example.domain.profile

import com.example.domain.profile.model.Topic

interface ProfileRemoteDataSource {
    suspend fun getAllTopics(): List<Topic>
}