package com.example.data.network.auth

import com.example.data.network.auth.model.AuthResponse
import com.example.data.network.auth.model.AuthRequest
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST

interface AuthApi {
    @POST("v1/auth/register")
    suspend fun signUp(@Body authRequest: AuthRequest): AuthResponse

    @POST("v1/auth/login")
    suspend fun signIn(@Body authRequest: AuthRequest): AuthResponse

    @DELETE("v1/auth/logout")
    suspend fun signOut()
}