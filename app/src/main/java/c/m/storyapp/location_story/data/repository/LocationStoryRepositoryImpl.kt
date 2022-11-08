package c.m.storyapp.location_story.data.repository

import c.m.storyapp.R
import c.m.storyapp.common.util.Constants
import c.m.storyapp.common.util.Resource
import c.m.storyapp.common.util.UIText
import c.m.storyapp.location_story.data.mapper.toLocationStoryResponse
import c.m.storyapp.location_story.data.remote.LocationStoryAPI
import c.m.storyapp.location_story.domain.model.LocationStoryResponse
import c.m.storyapp.location_story.domain.repository.LocationStoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import java.net.UnknownHostException
import javax.inject.Inject

class LocationStoryRepositoryImpl @Inject constructor(private val locationStoryAPI: LocationStoryAPI) :
    LocationStoryRepository {
    override suspend fun getLocationStory(token: String): Flow<Resource<LocationStoryResponse>> {
        return flow {
            // Loading State
            emit(Resource.Loading(isLoading = true))

            try {
                // Loading State
                emit(Resource.Loading(isLoading = false))

                val getLocationStory =
                    locationStoryAPI.getLocationStory("${Constants.BEARER}$token")

                if (getLocationStory.error) {
                    // Error State
                    emit(Resource.Error(message = UIText.DynamicString(getLocationStory.message)))
                }

                // Success State
                emit(Resource.Success(data = getLocationStory.toLocationStoryResponse()))

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