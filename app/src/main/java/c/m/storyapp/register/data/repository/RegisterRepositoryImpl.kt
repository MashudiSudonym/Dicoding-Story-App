package c.m.storyapp.register.data.repository

import c.m.storyapp.R
import c.m.storyapp.common.util.Resource
import c.m.storyapp.common.util.UIText
import c.m.storyapp.register.data.mapper.toRegisterResponse
import c.m.storyapp.register.data.remote.RegisterAPI
import c.m.storyapp.register.domain.model.RegisterResponse
import c.m.storyapp.register.domain.repository.RegisterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import java.net.UnknownHostException
import javax.inject.Inject

class RegisterRepositoryImpl @Inject constructor(private val registerAPI: RegisterAPI) :
    RegisterRepository {
    override suspend fun postRegister(
        name: String,
        email: String,
        password: String,
    ): Flow<Resource<RegisterResponse>> {
        return flow {
            // Loading State
            emit(Resource.Loading(isLoading = true))

            try {
                // Loading State
                emit(Resource.Loading(isLoading = false))

                val postRegister = registerAPI.postRegister(name, email, password)

                if (postRegister.error) {
                    // Error State
                    emit(Resource.Error(message = UIText.DynamicString(postRegister.message)))
                }

                // Success State
                emit(Resource.Success(data = postRegister.toRegisterResponse()))
                Timber.i(postRegister.toString())
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