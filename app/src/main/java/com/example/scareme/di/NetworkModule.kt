package com.example.scareme.di

import com.example.domain.auth.dataSource.AuthRemoteDataSource
import com.example.domain.auth.dataSource.AuthRemoteDataSourceImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val networkModule = module {

    // Provide AuthRemoteDataSource
    factoryOf(::AuthRemoteDataSourceImpl) { bind<AuthRemoteDataSource>() }

}