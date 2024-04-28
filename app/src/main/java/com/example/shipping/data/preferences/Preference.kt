package com.example.shipping.data.preferences

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.core.remove
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.first

class Preference(context: Context) {
    private val dataStore = context.createDataStore("ComeInDataStore")

    suspend fun saveCode(key: String, value: String) {
        dataStore.edit {
            it[preferencesKey<String>(key)] = value
        }
    }

    suspend fun readCode(key: String): String? = dataStore.data.first()[preferencesKey(key)]

    suspend fun removeCode(key: String) {
        dataStore.edit {
            it.remove(preferencesKey<String>(key))
        }
    }

    companion object {
        const val COMEINCODE = "come_in_code"
    }
}