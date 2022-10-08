package c.m.storyapp.list_story.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ListStoryResponseDTO(
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("listStory")
    val listStory: List<ListStoryDTO>
)
