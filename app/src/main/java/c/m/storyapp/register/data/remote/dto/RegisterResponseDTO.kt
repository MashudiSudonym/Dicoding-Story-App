package c.m.storyapp.register.data.remote.dto

import com.google.gson.annotations.SerializedName

data class RegisterResponseDTO(
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("message")
    val message: String,
)
