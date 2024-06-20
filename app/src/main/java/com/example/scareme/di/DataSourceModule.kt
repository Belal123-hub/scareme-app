package com.example.scareme.di

import com.example.data.dataStore.DataStoreDataSourceImpl
import com.example.data.network.auth.AuthRemoteDataSourceImpl
import com.example.domain.auth.dataSource.AuthRemoteDataSource
import com.example.domain.dataStore.DataStoreDataSource
import com.example.domain.profile.ProfileRemoteDataSource
import com.example.data.network.profile.ProfileRemoteDataSourceImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dataSourceModule = module {
    factoryOf(::DataStoreDataSourceImpl) { bind<DataStoreDataSource>() }
    factoryOf(::AuthRemoteDataSourceImpl) { bind<AuthRemoteDataSource>()}
    factoryOf(::ProfileRemoteDataSourceImpl) { bind<ProfileRemoteDataSource>()}
}