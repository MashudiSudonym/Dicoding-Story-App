package c.m.storyapp.list_story.data.repository

import c.m.storyapp.R
import c.m.storyapp.common.util.Constants
import c.m.storyapp.common.util.Resource
import c.m.storyapp.common.util.UIText
import c.m.storyapp.list_story.data.mapper.toListStoryResponse
import c.m.storyapp.list_story.data.remote.ListStoryAPI
import c.m.storyapp.list_story.domain.model.ListStoryResponse
import c.m.storyapp.list_story.domain.repository.ListStoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import java.net.UnknownHostException
import javax.inject.Inject

class ListStoryRepositoryImpl @Inject constructor(private val listStoryAPI: ListStoryAPI) :
    ListStoryRepository {
    override suspend fun getListStory(token: String): Flow<Resource<ListStoryResponse>> {
        return flow {
            // Loading state
            emit(Resource.Loading(isLoading = true))

            try {
                // Loading State
                emit(Resource.Loading(isLoading = false))

                val getListStory = listStoryAPI.getListStory("${Constants.BEARER}$token")

                if (getListStory.error) {
                    // Error State
                    emit(Resource.Error(message = UIText.DynamicString(getListStory.message)))
                }

                // Success State
                emit(Resource.Success(data = getListStory.toListStoryResponse()))
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
        }
    }
}