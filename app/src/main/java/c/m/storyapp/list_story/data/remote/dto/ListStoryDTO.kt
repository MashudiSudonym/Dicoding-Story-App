package c.m.storyapp.list_story.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ListStoryDTO(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("photoUrl")
    val photoUrl: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("lat")
    val latitude: Double,
    @SerializedName("lon")
    val longitude: Double,
)
