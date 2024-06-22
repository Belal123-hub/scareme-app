package com.example.data.network.profile

import com.example.data.network.profile.model.UpdateProfileRequestDto
import com.example.domain.profile.ProfileRemoteDataSource
import com.example.domain.profile.model.Topic
import com.example.domain.profile.model.UpdateProfileRequest

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

    override suspend fun updateProfile(request: UpdateProfileRequest) {
        val dto = UpdateProfileRequestDto(
            name = request.name,
            aboutMyself = request.aboutMyself,
            topics = request.topics
        )
         profileApi.updateProfile(dto)
    }
}
