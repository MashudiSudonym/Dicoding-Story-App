package c.m.storyapp.list_story.data.remote

import c.m.storyapp.common.util.Constants
import c.m.storyapp.list_story.data.remote.dto.ListStoryResponseDTO
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ListStoryAPI {
    @GET(Constants.STORIES_API)
    suspend fun getListStory(
        @Header(Constants.AUTHORIZATION) token: String,
        @Query(Constants.PAGE) page: Int,
        @Query(Constants.SIZE) size: Int,
    ): ListStoryResponseDTO
}