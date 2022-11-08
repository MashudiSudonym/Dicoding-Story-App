package c.m.storyapp.location_story.domain.repository

import c.m.storyapp.common.util.Resource
import c.m.storyapp.location_story.domain.model.LocationStoryResponse
import kotlinx.coroutines.flow.Flow

interface LocationStoryRepository {
    suspend fun getLocationStory(token: String): Flow<Resource<LocationStoryResponse>>
}