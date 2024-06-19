package com.example.domain.auth.dataSource

import com.example.domain.auth.dataSource.model.AccessToken

interface AuthRemoteDataSource {
    suspend fun signIn(email:String,password:String):AccessToken
    suspend fun signUp(email:String,password:String):AccessToken
    suspend fun signOut()
}

