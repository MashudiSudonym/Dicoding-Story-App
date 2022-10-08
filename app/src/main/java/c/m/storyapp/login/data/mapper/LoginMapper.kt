package c.m.storyapp.login.data.mapper

import c.m.storyapp.login.data.remote.dto.LoginResponseDTO
import c.m.storyapp.login.data.remote.dto.LoginResultDTO
import c.m.storyapp.login.domain.model.LoginResponse
import c.m.storyapp.login.domain.model.LoginResult

fun LoginResultDTO.toLoginResult(): LoginResult {
    return LoginResult(
        userId = userId,
        name = name,
        token = token,
    )
}

fun LoginResponseDTO.toLoginResponse(): LoginResponse {
    return LoginResponse(
        error = error,
        message = message,
        loginResult = loginResult.toLoginResult()
    )
}

