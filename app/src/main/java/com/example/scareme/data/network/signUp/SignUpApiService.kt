package com.example.scareme.signUpScreen.network

import com.example.scareme.signUpScreen.data.Token
import com.example.scareme.signUpScreen.data.UserData
import retrofit2.http.POST

interface SignUpApiService {

    @POST("auth/register")
    suspend fun getSignedUp(userData: UserData) : Token

    @POST("auth/login")
    suspend fun getLogin(userData: UserData) : Token
}