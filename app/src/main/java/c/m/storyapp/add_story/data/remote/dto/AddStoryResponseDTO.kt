package c.m.storyapp.add_story.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AddStoryResponseDTO(
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("message")
    val message: String,
)
