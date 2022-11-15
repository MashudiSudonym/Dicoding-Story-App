package c.m.storyapp.location_story.utils

import c.m.storyapp.common.util.Resource
import c.m.storyapp.location_story.data.mapper.toLocationStoryResponse
import c.m.storyapp.location_story.domain.model.LocationStoryResponse
import c.m.storyapp.location_story.domain.repository.LocationStoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeLocationStoryRepository : LocationStoryRepository {
    private val fakeLocationStoryResponseDTO =
        LocationStoryDataDummy.generateLocationStoryFakeDataResponseDTO()

    override suspend fun getLocationStory(token: String): Flow<Resource<LocationStoryResponse>> {
        return flow {
            emit(Resource.Loading(true))
            emit(Resource.Loading(false))
            emit(Resource.Success(fakeLocationStoryResponseDTO.toLocationStoryResponse()))
        }
    }
}