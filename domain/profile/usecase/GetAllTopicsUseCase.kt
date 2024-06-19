package com.blogspot.soyamr.domain.profile.usecase

import com.blogspot.soyamr.domain.profile.ProfileRepository
import com.blogspot.soyamr.domain.profile.model.Topic

interface GetAllTopicsUseCase {
    suspend operator fun invoke(): List<Topic>
}

class GetAllTopicsUseCaseImpl(
    private val profileRepository: ProfileRepository
) : GetAllTopicsUseCase {
    override suspend fun invoke(): List<Topic> = profileRepository.getAllTopics()
}