package c.m.storyapp.login.data.remote.dto

import c.m.storyapp.login.domain.model.LoginResult
import com.google.gson.annotations.SerializedName

data class LoginResponseDTO(
    @SerializedName("error")
    val error:Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("loginResult")
    val loginResult: LoginResultDTO,
)
