package com.example.domain.dataStore

import kotlinx.coroutines.flow.Flow

interface DataStoreDataSource {
    val isUserSignedIn: Flow<Boolean>

    suspend fun setIsUserSignedIn(isUserSignedIn: Boolean)
}