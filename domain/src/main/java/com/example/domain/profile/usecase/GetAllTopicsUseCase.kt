package com.example.domain.profile.usecase

import com.example.domain.profile.ProfileRepository
import com.example.domain.profile.model.Topic

interface GetAllTopicsUseCase {
    suspend operator fun invoke(): List<Topic>
}

class GetAllTopicsUseCaseImpl(
    private val profileRepository: ProfileRepository
) : GetAllTopicsUseCase {
    override suspend fun invoke(): List<Topic> = profileRepository.getAllTopics()
}