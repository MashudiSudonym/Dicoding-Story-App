package c.m.storyapp.register.utils

import c.m.storyapp.register.data.remote.dto.RegisterResponseDTO

object RegisterDataDummy {
    fun generateRegisterResponseFakeDataDTO(): RegisterResponseDTO {
        return RegisterResponseDTO(
            error = false,
            message = "User Created"
        )
    }

    fun generateRegisterErrorResponseFakeDataDTO(): RegisterResponseDTO {
        return RegisterResponseDTO(
            error = true,
            message = "User Already"
        )
    }
}