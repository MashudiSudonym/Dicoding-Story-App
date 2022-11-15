package c.m.storyapp.list_story.utils

import androidx.paging.PagingSource
import androidx.paging.PagingState
import c.m.storyapp.list_story.domain.model.Story

class FakeListStoryPagingSource : PagingSource<Int, Story>() {
    override fun getRefreshKey(state: PagingState<Int, Story>): Int {
        return 0
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Story> {
        return LoadResult.Page(emptyList(), 0, 1)
    }
}