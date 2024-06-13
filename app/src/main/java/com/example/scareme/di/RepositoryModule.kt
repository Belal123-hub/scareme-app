package com.example.scareme.di


import android.system.Os.bind
import com.example.domain.auth.AuthRepository
import com.example.domain.auth.AuthRepositoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import org.koin.core.module.dsl.bind
val repositoryModule = module {
    factoryOf(::AuthRepositoryImpl) { bind<AuthRepository>() }
}