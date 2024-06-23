package com.example.domain.profile

import com.example.domain.profile.model.Profile
import com.example.domain.profile.model.Topic
import com.example.domain.profile.model.UpdateProfileRequest

interface ProfileRepository {
    suspend fun getAllTopics(): List<Topic>
    suspend fun updateProfile(request: UpdateProfileRequest)
    suspend fun getProfile(): Profile

}

class ProfileRepositoryImpl(
    private val remoteDataSource: ProfileRemoteDataSource
) : ProfileRepository {
    override suspend fun getAllTopics(): List<Topic> = remoteDataSource.getAllTopics()
    override suspend fun updateProfile(request: UpdateProfileRequest) = remoteDataSource.updateProfile(request)
    override suspend fun getProfile(): Profile=remoteDataSource.getProfile()


}