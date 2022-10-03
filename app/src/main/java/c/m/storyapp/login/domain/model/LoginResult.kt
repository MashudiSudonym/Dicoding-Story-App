package c.m.storyapp.login.domain.model

data class LoginResult(
    val userId: String,
    val name: String,
    val token: String,
)
