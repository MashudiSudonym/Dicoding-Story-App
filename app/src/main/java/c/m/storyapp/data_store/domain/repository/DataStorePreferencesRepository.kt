package c.m.storyapp.data_store.domain.repository

interface DataStorePreferencesRepository {
    suspend fun setToken(token: String)
    suspend fun getToken(): Result<String>
}