package com.example.scareme.data.network.signIn


import com.example.scareme.signUpScreen.data.AppContainer
import com.example.scareme.signUpScreen.data.SignUpRepository
import okhttp3.OkHttpClient
import okhttp3.OkHttpClient.Builder
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer2 {
    val signInRepository : SignInRepository
}

class DefaultAppContainer : AppContainer2, AppContainer {


    val BASE_URL = " http://itindr.mcenter.pro:8092/api/mobile/v1/"

    val interceptor = HttpLoggingInterceptor()

    val client : OkHttpClient = Builder().addInterceptor(interceptor).build()
    val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitService : SignInApiService = retrofit.create(SignInApiService::class.java)

    override val signInRepository: SignInRepository by lazy {
        NetworkSignInRepository(retrofitService)
    }
    override val signUpRepository: SignUpRepository
        get() = TODO("Not yet implemented")
}