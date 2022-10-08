package c.m.storyapp.list_story.domain.repository

import c.m.storyapp.common.util.Resource
import c.m.storyapp.list_story.domain.model.ListStoryResponse
import kotlinx.coroutines.flow.Flow

interface ListStoryRepository {
    suspend fun getListStory(token: String): Flow<Resource<ListStoryResponse>>
}