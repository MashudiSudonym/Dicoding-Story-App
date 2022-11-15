package c.m.storyapp.add_story.utils

import c.m.storyapp.add_story.data.mapper.toAddStoryResponse
import c.m.storyapp.add_story.domain.model.AddStoryResponse
import c.m.storyapp.add_story.domain.repository.AddStoryRepository
import c.m.storyapp.common.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.MultipartBody
import okhttp3.RequestBody

class FakeAddStoryRepository : AddStoryRepository {
    private val fakeAddStoryResponseDTO = AddStoryDataDummy.generateAddStoryResponseDTODataDummy()

    override suspend fun postStory(
        token: String,
        photo: MultipartBody.Part,
        description: RequestBody,
    ): Flow<Resource<AddStoryResponse>> {
        return flow {
            emit(Resource.Loading(true))
            emit(Resource.Loading(false))
            emit(Resource.Success(fakeAddStoryResponseDTO.toAddStoryResponse()))
        }
    }
}