package c.m.storyapp.register.presentation.state

import c.m.storyapp.common.util.UIText

data class RegisterUIState(
    val isLoading: Boolean = false,
    val errorMessage: UIText? = null,
    val isSuccess: Boolean = false,
    val isError: Boolean = false,
    val name: String = "",
    val nameFieldError: UIText? = null,
    val email: String = "",
    val emailFieldError: UIText? = null,
    val password: String = "",
    val passwordFieldError: UIText? = null,
)
