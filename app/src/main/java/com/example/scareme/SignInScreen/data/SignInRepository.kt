package com.example.scareme.signInScreen.data

import com.example.scareme.signInScreen.network.SignInApiService


interface  SignInRepository{
    suspend fun getUserSignIn(userData: UserData) : Token
}

class NetworkSignInRepository(
    private val signInApiService: SignInApiService
) : SignInRepository {

    override suspend fun getUserSignIn(userData: UserData): Token {
        return signInApiService.getSignedIn(userData)
    }
}