package com.example.scareme.signInScreen.network

import com.example.scareme.signInScreen.data.Token
import com.example.scareme.signInScreen.data.UserData
import retrofit2.http.POST

interface SignInApiService {

    @POST("auth/login")
    suspend fun getSignedIn(userData: UserData) : Token

}