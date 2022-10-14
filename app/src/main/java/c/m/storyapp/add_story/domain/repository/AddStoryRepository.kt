package c.m.storyapp.add_story.domain.repository

import c.m.storyapp.add_story.domain.model.AddStoryResponse
import c.m.storyapp.common.util.Resource
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import okhttp3.RequestBody

interface AddStoryRepository {
    suspend fun postStory(
        token: String,
        photo: MultipartBody.Part,
        description: RequestBody,
    ): Flow<Resource<AddStoryResponse>>
}