package com.example.scareme

import android.app.Application
import com.example.scareme.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ScareMeApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@ScareMeApplication)
            // Load modules
             modules(appComponent)
        }
    }
    
}

