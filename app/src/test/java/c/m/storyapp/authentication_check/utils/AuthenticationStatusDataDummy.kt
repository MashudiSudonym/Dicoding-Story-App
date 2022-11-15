package c.m.storyapp.authentication_check.utils

import c.m.storyapp.authentication_check.domain.model.AuthenticationStatus

object AuthenticationStatusDataDummy {
    fun generateAuthenticationStatusSuccessFakeData(): AuthenticationStatus {
        return AuthenticationStatus(
            isAuthenticated = true
        )
    }
}