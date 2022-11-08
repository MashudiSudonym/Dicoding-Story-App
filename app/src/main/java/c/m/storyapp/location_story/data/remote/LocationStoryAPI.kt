package c.m.storyapp.location_story.data.remote

import c.m.storyapp.common.util.Constants
import c.m.storyapp.location_story.data.remote.dto.LocationStoryResponseDTO
import retrofit2.http.GET
import retrofit2.http.Header

interface LocationStoryAPI {
    @GET(Constants.PARAM_LOCATION)
    suspend fun getLocationStory(
        @Header(Constants.AUTHORIZATION) token: String,
    ): LocationStoryResponseDTO
}