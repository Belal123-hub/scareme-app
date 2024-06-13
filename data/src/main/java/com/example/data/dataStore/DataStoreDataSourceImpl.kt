package com.example.data.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.domain.dataStore.DataStoreDataSource
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "app_name")

class DataStoreDataSourceImpl(
    context: Context
) : DataStoreDataSource {

    private val dataStore = context.dataStore

    override val isUserSignedIn = dataStore.data
        .map { preferences -> preferences[IS_USER_SIGNED_IN] ?: false }


    override suspend fun setIsUserSignedIn(isUserSignedIn: Boolean) {
        dataStore.edit { preferences ->
            preferences[IS_USER_SIGNED_IN] = isUserSignedIn
        }
    }

    private companion object {
        val IS_USER_SIGNED_IN = booleanPreferencesKey("is_user_signed_in")
    }
}