package c.m.storyapp.login.data.remote

import c.m.storyapp.common.util.Constants
import c.m.storyapp.login.data.remote.dto.LoginResponseDTO
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginAPI {
    @FormUrlEncoded
    @POST(Constants.LOGIN_API)
    suspend fun postLogin(
        @Field(Constants.EMAIL) email: String,
        @Field(Constants.PASSWORD) password: String,
    ): LoginResponseDTO
}