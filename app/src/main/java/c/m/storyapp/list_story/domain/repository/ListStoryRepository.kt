package c.m.storyapp.list_story.domain.repository

import androidx.paging.PagingData
import c.m.storyapp.common.util.Resource
import c.m.storyapp.list_story.domain.model.Story
import kotlinx.coroutines.flow.Flow

interface ListStoryRepository {
    suspend fun getListStory(token: String): Flow<Resource<Flow<PagingData<Story>>>>
}