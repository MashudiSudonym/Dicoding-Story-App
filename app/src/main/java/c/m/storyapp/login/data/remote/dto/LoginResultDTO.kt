package c.m.storyapp.login.data.remote.dto

import com.google.gson.annotations.SerializedName

data class LoginResultDTO(
    @SerializedName("userId")
    val userId: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("token")
    val token: String,
)
