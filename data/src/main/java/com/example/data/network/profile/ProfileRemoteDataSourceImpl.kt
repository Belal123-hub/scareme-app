package com.example.data.network.profile

import com.example.domain.profile.ProfileRemoteDataSource
import com.example.domain.profile.model.Topic

class ProfileRemoteDataSourceImpl(
    private val profileApi: ProfileApi,
) : ProfileRemoteDataSource {

    override suspend fun getAllTopics(): List<Topic> {
        return profileApi.getAllTopics().map { topic ->
            Topic(
                id = topic.id,
                title = topic.title
            )
        }
    }
}