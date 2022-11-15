package c.m.storyapp.list_story.utils

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import c.m.storyapp.common.util.Constants
import c.m.storyapp.common.util.Resource
import c.m.storyapp.list_story.domain.model.Story
import c.m.storyapp.list_story.domain.repository.ListStoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeListStoryRepository : ListStoryRepository {
    override suspend fun getListStory(token: String): Flow<Resource<Flow<PagingData<Story>>>> {
        return flow {
            emit(Resource.Loading(true))
            emit(Resource.Loading(false))

            // Get Data
            val pagingData = Pager(
                config = PagingConfig(pageSize = Constants.INITIAL_SIZE),
                pagingSourceFactory = {
                    FakeListStoryPagingSource()
                }
            ).flow

            // Success State
            emit(Resource.Success(pagingData))
        }
    }
}