package c.m.storyapp.register.data.mapper

import c.m.storyapp.register.data.remote.dto.RegisterResponseDTO
import c.m.storyapp.register.domain.model.RegisterResponse


fun RegisterResponseDTO.toRegisterResponse(): RegisterResponse {
    return RegisterResponse(
        error = error,
        message = message,
    )
}

fun RegisterResponse.toRegisterResponseDTO(): RegisterResponseDTO {
    return RegisterResponseDTO(
        error = error,
        message = message,
    )
}