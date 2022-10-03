package c.m.storyapp.authentication_check.data.repository

import c.m.storyapp.R
import c.m.storyapp.authentication_check.domain.model.AuthenticationStatus
import c.m.storyapp.authentication_check.domain.repository.AuthenticationCheckRepository
import c.m.storyapp.common.util.Resource
import c.m.storyapp.common.util.SimpleResource
import c.m.storyapp.common.util.UIText
import c.m.storyapp.data_store.domain.repository.DataStorePreferencesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class AuthenticationCheckRepositoryImpl @Inject constructor(
    private val dataStorePreferencesRepository: DataStorePreferencesRepository,
) : AuthenticationCheckRepository {
    override suspend fun saveToken(token: String): Flow<SimpleResource> {
        return flow {
            // Loading State
            emit(Resource.Loading(isLoading = true))

            if (token != "") {
                // Loading State
                emit(Resource.Loading(isLoading = false))

                // Success Saved Token
                val saveToken = dataStorePreferencesRepository.setToken(token)
                emit(Resource.Success(data = saveToken))
            } else {
                // Loading State
                emit(Resource.Loading(isLoading = false))

                // If token is empty string, save blank string
                val saveToken = dataStorePreferencesRepository.setToken("")
                emit(Resource.Error(message =
                    UIText.StringResource(R.string.error_token_failed_to_save),
                    saveToken,
                ))
            }
        }
    }

    override suspend fun checkAuthentication(): Flow<Resource<AuthenticationStatus>> {
        return flow {
            // Loading State
            emit(Resource.Loading(isLoading = true))

            try {
                val getCacheToken = dataStorePreferencesRepository.getToken()

                // Error State : token not found!
                if (getCacheToken.getOrDefault("").isEmpty()) {
                    // Loading State
                    emit(Resource.Loading(isLoading = false))

                    // Error State
                    emit(Resource.Error(message = UIText.StringResource(R.string.error_not_authenticated),
                        data = AuthenticationStatus(isAuthenticated = false)))
                } else {
                    // Loading State
                    emit(Resource.Loading(isLoading = false))

                    // Success State
                    emit(Resource.Success(data = AuthenticationStatus(isAuthenticated = true)))
                }
            } catch (e: Exception) {
                // Loading State
                emit(Resource.Loading(isLoading = false))

                // Error State
                Timber.e(e.localizedMessage)
                emit(Resource.Error(message = UIText.unknownError(),
                    data = AuthenticationStatus(isAuthenticated = false)))
            }
        }
    }
}