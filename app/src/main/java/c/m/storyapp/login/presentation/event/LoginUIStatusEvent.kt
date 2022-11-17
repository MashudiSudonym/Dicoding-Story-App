package c.m.storyapp.login.presentation.event

sealed class LoginUIStatusEvent {
    object Error : LoginUIStatusEvent()
}
