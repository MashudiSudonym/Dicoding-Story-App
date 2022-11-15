package c.m.storyapp.authentication_check.utils

import c.m.storyapp.authentication_check.presentation.state.AuthenticationCheckUIState

object AuthenticationCheckUIStateDataDummy {
    fun generateAuthenticationCheckUIStateSuccessStateFakeData(): AuthenticationCheckUIState {
        return AuthenticationCheckUIState(
            isAuthenticated = true,
            isError = false,
            isLoading = false,
        )
    }
}