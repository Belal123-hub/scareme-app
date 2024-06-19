package com.blogspot.soyamr.domain.profile

import com.blogspot.soyamr.domain.profile.model.Topic

interface ProfileRemoteDataSource {
    suspend fun getAllTopics(): List<Topic>
}