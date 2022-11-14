package c.m.storyapp.list_story.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import c.m.storyapp.R
import c.m.storyapp.common.util.Constants
import c.m.storyapp.common.util.Resource
import c.m.storyapp.common.util.UIText
import c.m.storyapp.list_story.data.paging.ListStoryPagingSource
import c.m.storyapp.list_story.data.remote.ListStoryAPI
import c.m.storyapp.list_story.domain.model.Story
import c.m.storyapp.list_story.domain.repository.ListStoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import java.net.UnknownHostException
import javax.inject.Inject

class ListStoryRepositoryImpl @Inject constructor(private val listStoryAPI: ListStoryAPI) :
    ListStoryRepository {
    override suspend fun getListStory(token: String): Flow<Resource<Flow<PagingData<Story>>>> {
        return flow {
            // Loading State
            emit(Resource.Loading(true))

            try {
                // Loading State
                emit(Resource.Loading(isLoading = false))

                // Get Data
                val pagingData = Pager(
                    config = PagingConfig(pageSize = Constants.INITIAL_SIZE),
                    pagingSourceFactory = {
                        ListStoryPagingSource(listStoryAPI = listStoryAPI, token = token)
                    }
                ).flow

                // Success State
                emit(Resource.Success(pagingData))

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