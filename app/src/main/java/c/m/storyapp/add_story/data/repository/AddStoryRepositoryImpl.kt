package c.m.storyapp.add_story.data.repository

import c.m.storyapp.R
import c.m.storyapp.add_story.data.mapper.toAddStoryResponse
import c.m.storyapp.add_story.data.remote.AddStoryAPI
import c.m.storyapp.add_story.domain.model.AddStoryResponse
import c.m.storyapp.add_story.domain.repository.AddStoryRepository
import c.m.storyapp.common.util.Constants
import c.m.storyapp.common.util.Resource
import c.m.storyapp.common.util.UIText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import java.net.UnknownHostException
import javax.inject.Inject

class AddStoryRepositoryImpl @Inject constructor(private val addStoryAPI: AddStoryAPI) :
    AddStoryRepository {
    override suspend fun postStory(
        token: String,
        photo: MultipartBody.Part,
        description: RequestBody,
    ): Flow<Resource<AddStoryResponse>> {
        return flow {
            // Loading State
            emit(Resource.Loading(isLoading = true))

            try {
                // Loading State
                emit(Resource.Loading(isLoading = false))

                val postStory =
                    addStoryAPI.postStory("${Constants.BEARER}$token", photo, description)

                if (postStory.error) {
                    // Error State
                    emit(Resource.Error(message = UIText.DynamicString(postStory.message)))
                }

                // Success State
                emit(Resource.Success(data = postStory.toAddStoryResponse()))
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