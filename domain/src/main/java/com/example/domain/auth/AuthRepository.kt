package com.example.domain.auth

import com.example.domain.auth.dataSource.AuthRemoteDataSource
import com.example.domain.dataStore.DataStoreDataSource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun isUserSignedIn(): Flow<Boolean>
    suspend fun setIsUserSignedIn(isUserSignedIn: Boolean)
    suspend fun signIn()
    suspend fun signUp()
    suspend fun signOut()
}

class AuthRepositoryImpl(
    private val dataStoreDataSource: DataStoreDataSource,
    private val authRemoteDataSource: AuthRemoteDataSource,
) : AuthRepository {
    override fun isUserSignedIn() = dataStoreDataSource.isUserSignedIn

    override suspend fun setIsUserSignedIn(isUserSignedIn: Boolean) = dataStoreDataSource.setIsUserSignedIn(isUserSignedIn)

    override suspend fun signIn() {}

    override suspend fun signUp() {}

    override suspend fun signOut() {}
}