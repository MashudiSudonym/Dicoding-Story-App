package c.m.storyapp.login.utils

import c.m.storyapp.common.util.UIText
import c.m.storyapp.login.presentation.state.LoginUIState

object LoginUIStateDataDummy {
    fun generateLoginUIStateSuccessLoginStateDataDummy(): LoginUIState {
        return LoginUIState(
            isLoading = false,
            errorMessage = null,
            isSuccess = true,
            isError = false,
            email = "email.e@email.com",
            emailFieldError = null,
            password = "123tes",
            passwordFieldError = null,
        )
    }

    fun generateLoginUIStateFailedLoginStateDataDummy(): LoginUIState {
        return LoginUIState(
            isLoading = false,
            errorMessage = UIText.unknownError(),
            isSuccess = false,
            isError = true,
        )
    }
}