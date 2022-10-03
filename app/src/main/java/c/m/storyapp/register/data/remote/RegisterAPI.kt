package c.m.storyapp.register.data.remote

import c.m.storyapp.common.util.Constants
import c.m.storyapp.register.data.remote.dto.RegisterResponseDTO
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RegisterAPI {
    @FormUrlEncoded
    @POST(Constants.REGISTER_API)
    suspend fun postRegister(
        @Field(Constants.NAME) name: String,
        @Field(Constants.EMAIL) email: String,
        @Field(Constants.PASSWORD) password: String,
    ): RegisterResponseDTO
}