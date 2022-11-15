package c.m.storyapp.authentication_check.utils

import c.m.storyapp.authentication_check.domain.model.AuthenticationToken

object AuthenticationTokenDataDummy {
    fun generateAuthenticationTokenFakeData(): AuthenticationToken {
        return AuthenticationToken(token = "token1234")
    }
}