package com.example.scareme.signUpScreen.data

import com.example.scareme.signUpScreen.network.SignUpApiService


interface  SignUpRepository{
    suspend fun getUserSignUp(userData: UserData) : Token
}

class NetworkSignUpRepository(
    private val signUpApiService: SignUpApiService
) : SignUpRepository {

    override suspend fun getUserSignUp(userData: UserData): Token {
        return signUpApiService.getSignedUp(userData)
    }
}