package com.example.scareme.data.network.signIn

import com.example.scareme.data.network.signIn.Token
import com.example.scareme.data.network.signIn.UserData
import retrofit2.http.POST

interface SignInApiService {

    @POST("auth/login")
    suspend fun getSignedIn(userData: UserData) : Token
    @POST("auth/login")
    suspend fun getLogin(userData: UserData) : Token

}