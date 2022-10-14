package c.m.storyapp.add_story.data.remote

import c.m.storyapp.add_story.data.remote.dto.AddStoryResponseDTO
import c.m.storyapp.common.util.Constants
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface AddStoryAPI {
    @Multipart
    @POST(Constants.STORIES_API)
    suspend fun postStory(
        @Header(Constants.AUTHORIZATION) token: String,
        @Part photo: MultipartBody.Part,
        @Part(Constants.DESCRIPTION) description: RequestBody
    ): AddStoryResponseDTO
}