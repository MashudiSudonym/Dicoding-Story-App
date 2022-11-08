package c.m.storyapp.location_story.data.remote.dto

import c.m.storyapp.location_story.data.remote.dto.LocationStoryListStoryDTO
import com.google.gson.annotations.SerializedName

data class LocationStoryResponseDTO(
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("listStory")
    val locationStoryListStory: List<LocationStoryListStoryDTO>,
)
