package c.m.storyapp.authentication_check.presentation.state

data class AuthenticationCheckUIState(
    val isLoading: Boolean = false,
    val isAuthenticated: Boolean = false,
    val isError: Boolean = false
)