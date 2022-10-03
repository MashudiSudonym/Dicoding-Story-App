package c.m.storyapp.data_store.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import c.m.storyapp.common.util.Constants
import c.m.storyapp.data_store.domain.repository.DataStorePreferencesRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class DataStorePreferencesRepositoryImpl @Inject constructor(private val credentialDataStoragePreferences: DataStore<Preferences>) :
    DataStorePreferencesRepository {
    override suspend fun setToken(token: String) {
        Result.runCatching {
            credentialDataStoragePreferences.edit { preferences ->
                preferences[Constants.TOKEN] = token
            }
        }
    }

    override suspend fun getToken(): Result<String> {
        return Result.runCatching {
            val flow = credentialDataStoragePreferences.data.catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }.map { preferences ->
                preferences[Constants.TOKEN]
            }
            val value = flow.firstOrNull() ?: ""
            value
        }
    }
}