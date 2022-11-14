package c.m.storyapp.list_story.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import c.m.storyapp.common.util.Constants
import c.m.storyapp.list_story.data.mapper.toListStoryResponse
import c.m.storyapp.list_story.data.remote.ListStoryAPI
import c.m.storyapp.list_story.domain.model.Story
import java.io.IOException
import javax.inject.Inject

class ListStoryPagingSource @Inject constructor(
    private val listStoryAPI: ListStoryAPI,
    private val token: String,
) :
    PagingSource<Int, Story>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Story> {
        return try {
            val position = params.key ?: Constants.INITIAL_PAGE_INDEX
            val response =
                listStoryAPI.getListStory("${Constants.BEARER}$token", position, params.loadSize)
                    .toListStoryResponse()

            LoadResult.Page(
                data = response.listStory.orEmpty(),
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (response.listStory.isNullOrEmpty()) null else position + 1,
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        } catch (e: IOException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Story>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}