package c.m.storyapp.register.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import c.m.storyapp.common.domain.use_case.field_validation_use_case.EmailFieldValidationUseCase
import c.m.storyapp.common.domain.use_case.field_validation_use_case.NameFieldValidationUseCase
import c.m.storyapp.common.domain.use_case.field_validation_use_case.PasswordFieldValidationUseCase
import c.m.storyapp.common.util.Resource
import c.m.storyapp.register.domain.use_case.user_register_use_case.UserRegisterUseCase
import c.m.storyapp.register.presentation.state.RegisterUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val userRegisterUseCase: UserRegisterUseCase,
    private val nameFieldValidationUseCase: NameFieldValidationUseCase,
    private val emailFieldValidationUseCase: EmailFieldValidationUseCase,
    private val passwordFieldValidationUseCase: PasswordFieldValidationUseCase,
) : ViewModel() {
    private val _registerUIState = MutableStateFlow(RegisterUIState())
    val registerUIState: StateFlow<RegisterUIState> = _registerUIState

    fun submitRegisterData(name: String, email: String, password: String) {
        _registerUIState.update { it.copy(isLoading = true) }
        _registerUIState.update { it.copy(isLoading = false, name = name, nameFieldError = null) }
        _registerUIState.update {
            it.copy(isLoading = false,
                email = email,
                emailFieldError = null)
        }
        _registerUIState.update {
            it.copy(isLoading = false,
                password = password,
                passwordFieldError = null)
        }

        val nameResult = nameFieldValidationUseCase.execute(_registerUIState.value.name)
        val emailResult = emailFieldValidationUseCase.execute(_registerUIState.value.email)
        val passwordResult = passwordFieldValidationUseCase.execute(_registerUIState.value.password)
        val hasError = listOf(nameResult, emailResult, passwordResult).any {
            !it.successful
        }

        if (hasError) {
            _registerUIState.update {
                it.copy(
                    isLoading = false,
                    nameFieldError = nameResult.errorMessage,
                    emailFieldError = emailResult.errorMessage,
                    passwordFieldError = passwordResult.errorMessage
                )
            }
        } else {
            userRegistrationProcess()
        }
    }

    private fun userRegistrationProcess() {
        viewModelScope.launch {
            userRegisterUseCase(
                _registerUIState.value.name,
                _registerUIState.value.email,
                _registerUIState.value.password,
            ).collect { result ->
                when (result) {
                    is Resource.Error -> {
                        _registerUIState.update {
                            it.copy(isLoading = false,
                                errorMessage = result.message,
                                isError = true)
                        }
                    }
                    is Resource.Loading -> {
                        _registerUIState.update { it.copy(isLoading = true, isError = false) }
                    }
                    is Resource.Success -> {
                        _registerUIState.update {
                            it.copy(isLoading = false,
                                isError = false,
                                isSuccess = true)
                        }
                    }
                }
            }
        }
    }
}