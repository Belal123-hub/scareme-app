package com.example.scareme.data.network.signIn


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