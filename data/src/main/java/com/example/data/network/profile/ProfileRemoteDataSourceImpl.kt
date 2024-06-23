package com.example.data.network.profile

import com.example.data.network.profile.model.UpdateProfileRequestDto
import com.example.domain.profile.ProfileRemoteDataSource
import com.example.domain.profile.model.Profile
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

    override suspend fun getProfile(): Profile {
        val response = profileApi.getProfile()
        return Profile(
            userId = response.userId,
            name = response.name,
            aboutMyself = response.aboutMyself,
            avatar = response.avatar,
            topics = response.topics.map { Topic(it.id, it.title) }
        )
    }
}
