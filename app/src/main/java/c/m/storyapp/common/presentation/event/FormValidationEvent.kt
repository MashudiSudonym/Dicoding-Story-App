package c.m.storyapp.common.presentation.event

sealed class FormValidationEvent {
    object Success: FormValidationEvent()
}