package c.m.storyapp.login.utils

import c.m.storyapp.login.data.remote.dto.LoginResponseDTO
import c.m.storyapp.login.data.remote.dto.LoginResultDTO

object LoginDataDummy {
    private fun generateLoginResultFakeDataDTO(): LoginResultDTO {
        return LoginResultDTO(
            userId = "1",
            name = "user name",
            token = "lorem123"
        )
    }

    fun generateLoginResponseFakeDataDTO(): LoginResponseDTO {
        val fakeLoginResultDTO = generateLoginResultFakeDataDTO()

        return LoginResponseDTO(
            error = false,
            message = "login success",
            loginResult = fakeLoginResultDTO
        )
    }

    fun generateLoginErrorResponseFakeDataDTO(): LoginResponseDTO {
        val fakeLoginResultDTO = generateLoginResultFakeDataDTO()

        return LoginResponseDTO(
            error = true,
            message = "login failed",
            loginResult = fakeLoginResultDTO
        )
    }
}