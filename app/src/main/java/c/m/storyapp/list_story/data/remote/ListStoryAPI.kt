package c.m.storyapp.list_story.data.remote

import c.m.storyapp.common.util.Constants
import c.m.storyapp.list_story.data.remote.dto.ListStoryResponseDTO
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Header

interface ListStoryAPI {
    @GET(Constants.STORIES_API)
    suspend fun getListStory(
        @Header(Constants.AUTHORIZATION) token: String,
        @Field(Constants.PAGE) page: Int,
        @Field(Constants.SIZE) size: Int,
    ): ListStoryResponseDTO
}