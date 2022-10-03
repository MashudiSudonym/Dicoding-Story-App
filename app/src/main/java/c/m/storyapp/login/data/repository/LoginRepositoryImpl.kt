package c.m.storyapp.login.data.repository

import c.m.storyapp.R
import c.m.storyapp.common.util.Resource
import c.m.storyapp.common.util.SimpleResource
import c.m.storyapp.common.util.UIText
import c.m.storyapp.data_store.domain.repository.DataStorePreferencesRepository
import c.m.storyapp.login.data.mapper.toLoginResponse
import c.m.storyapp.login.data.remote.LoginAPI
import c.m.storyapp.login.domain.model.LoginResponse
import c.m.storyapp.login.domain.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import java.net.UnknownHostException
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginAPI: LoginAPI
) : LoginRepository {
    override suspend fun postLogin(email: String, password: String): Flow<Resource<LoginResponse>> {
        return flow {
            // Loading State
            emit(Resource.Loading(isLoading = true))

            try {
                // Loading State
                emit(Resource.Loading(isLoading = false))

                val postLogin = loginAPI.postLogin(email, password)

                if (postLogin.error) {
                    // Error State
                    emit(Resource.Error(message = UIText.DynamicString(postLogin.message)))
                }

                // Success State
                emit(Resource.Success(data = postLogin.toLoginResponse()))
            } catch (e: HttpException) {
                // Loading State
                emit(Resource.Loading(isLoading = false))

                // Error State
                Timber.e(e.localizedMessage)
                emit(
                    Resource.Error(message = UIText.StringResource(R.string.error_internet_problem))
                )
            } catch (e: IOException) {
                // Loading State
                emit(Resource.Loading(isLoading = false))

                // Error State
                Timber.e(e.localizedMessage)
                emit(
                    Resource.Error(message = UIText.StringResource(R.string.error_internet_problem))
                )
            } catch (e: UnknownHostException) {
                // Loading State
                emit(Resource.Loading(isLoading = false))

                // Error State
                Timber.e(e.localizedMessage)
                emit(
                    Resource.Error(message = UIText.StringResource(R.string.error_unknown))
                )
            }
        }.flowOn(Dispatchers.IO)
    }
}