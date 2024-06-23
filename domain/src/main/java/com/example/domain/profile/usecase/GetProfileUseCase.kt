package com.example.domain.profile.usecase

import com.example.domain.profile.ProfileRepository
import com.example.domain.profile.model.Profile

interface GetProfileUseCase {
    suspend operator fun invoke(): Profile
}

class GetProfileUseCaseImpl(
    private val profileRepository: ProfileRepository
) : GetProfileUseCase {
    override suspend fun invoke(): Profile = profileRepository.getProfile()
}