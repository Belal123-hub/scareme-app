package com.example.domain.profile

import com.example.domain.profile.model.Topic

interface ProfileRepository {
    suspend fun getAllTopics(): List<Topic>
}

class ProfileRepositoryImpl(
    private val remoteDataSource: ProfileRemoteDataSource
) : ProfileRepository {
    override suspend fun getAllTopics(): List<Topic> = remoteDataSource.getAllTopics()
}