package com.example.scareme.signUpScreen.data


import com.example.scareme.signUpScreen.network.SignUpApiService
import okhttp3.OkHttpClient
import okhttp3.OkHttpClient.Builder
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val signUpRepository : SignUpRepository
}

class DefaultAppContainer : AppContainer {


    val BASE_URL = " http://itindr.mcenter.pro:8092/api/mobile/v1/"

    val interceptor = HttpLoggingInterceptor()

    val client : OkHttpClient = Builder().addInterceptor(interceptor).build()
    val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitService : SignUpApiService = retrofit.create(SignUpApiService::class.java)

    override val signUpRepository: SignUpRepository by lazy {
        NetworkSignUpRepository(retrofitService)
    }
}