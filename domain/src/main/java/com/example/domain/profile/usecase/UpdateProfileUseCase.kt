package com.example.domain.profile.usecase

import com.example.domain.profile.ProfileRepository
import com.example.domain.profile.model.UpdateProfileRequest

interface UpdateProfileUseCase {
    suspend operator fun invoke(request: UpdateProfileRequest)
}

class UpdateProfileUseCaseImpl(
    private val profileRepository: ProfileRepository
) : UpdateProfileUseCase {
    override suspend fun invoke(request: UpdateProfileRequest) {
        return profileRepository.updateProfile(request)
    }
}
