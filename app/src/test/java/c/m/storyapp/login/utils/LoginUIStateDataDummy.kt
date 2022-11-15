package c.m.storyapp.login.utils

import c.m.storyapp.login.presentation.state.LoginUIState

object LoginUIStateDataDummy {
    fun generateLoginUIStateSuccessStateDataDummy(): LoginUIState {
        return LoginUIState(
            isLoading = false,
            isError = false,
            isSuccess = true,
        )
    }
}