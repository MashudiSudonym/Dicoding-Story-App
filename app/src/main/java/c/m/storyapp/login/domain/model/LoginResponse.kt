package c.m.storyapp.login.domain.model

data class LoginResponse(
    val error: Boolean,
    val message: String,
    val loginResult: LoginResult
)
