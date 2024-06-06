package com.example.scareme

import android.app.Application
import com.example.scareme.data.network.signIn.AppContainer2
import com.example.scareme.data.network.signIn.DefaultAppContainer
import com.example.scareme.signUpScreen.data.AppContainer

class ScareMeApplication : Application() {
    lateinit var container : AppContainer
    lateinit var container2: AppContainer2

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}