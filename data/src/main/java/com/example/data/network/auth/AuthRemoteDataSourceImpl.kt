package com.example.data.network.auth

import com.example.data.network.auth.AuthApi
import com.example.data.network.auth.model.AuthRequest
import com.example.domain.auth.dataSource.AuthRemoteDataSource
import com.example.domain.auth.dataSource.model.AccessToken


class AuthRemoteDataSourceImpl(
    private val authApi: AuthApi
): AuthRemoteDataSource {
    override suspend fun signIn(email: String, password: String): AccessToken {
        val response = authApi.signIn(AuthRequest(email, password))
        return AccessToken(response.accessToken, response.refreshToken)
    }

    override suspend fun signUp(email: String, password: String): AccessToken {
        val response = authApi.signUp(AuthRequest(email, password))
        return AccessToken(response.accessToken, response.refreshToken)
    }

    override suspend fun signOut() {
        authApi.signOut()
    }
}