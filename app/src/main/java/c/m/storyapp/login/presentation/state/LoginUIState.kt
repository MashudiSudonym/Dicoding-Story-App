package c.m.storyapp.login.presentation.state

import c.m.storyapp.common.util.UIText

data class LoginUIState(
    val isLoading: Boolean = false,
    val errorMessage: UIText? = null,
    val isSuccess: Boolean = false,
    val isError: Boolean = false,
    val email: String = "",
    val emailFieldError: UIText? = null,
    val password: String = "",
    val passwordFieldError: UIText? = null,
)
