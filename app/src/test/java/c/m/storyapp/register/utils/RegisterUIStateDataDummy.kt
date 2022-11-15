package c.m.storyapp.register.utils

import c.m.storyapp.register.presentation.state.RegisterUIState

object RegisterUIStateDataDummy {
    fun generateRegisterUIStateDataDummySuccessState(): RegisterUIState {
        return RegisterUIState(
            isLoading = false,
            isError = false,
            isSuccess = true
        )
    }
}