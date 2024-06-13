package com.example.scareme.di

import com.example.data.dataStore.DataStoreDataSourceImpl
import com.example.domain.dataStore.DataStoreDataSource
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dataSourceModule = module {
    factoryOf(::DataStoreDataSourceImpl) { bind<DataStoreDataSource>() }
}