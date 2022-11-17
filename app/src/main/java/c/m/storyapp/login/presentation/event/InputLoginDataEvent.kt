package c.m.storyapp.login.presentation.event

sealed class InputLoginDataEvent {
    data class EmailFieldChange(val email: String) : InputLoginDataEvent()
    data class PasswordFieldChange(val password: String) : InputLoginDataEvent()

    object SendLoginFieldData : InputLoginDataEvent()
    object Submit : InputLoginDataEvent()
}
