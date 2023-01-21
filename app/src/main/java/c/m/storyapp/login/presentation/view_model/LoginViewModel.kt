package c.m.storyapp.login.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import c.m.storyapp.R
import c.m.storyapp.authentication_check.domain.use_case.save_token_to_data_store_use_case.SaveTokenToDataStoreUseCase
import c.m.storyapp.common.util.Resource
import c.m.storyapp.common.util.UIText
import c.m.storyapp.form_validation.domain.use_case.field_validation_use_case.EmailFieldValidationUseCase
import c.m.storyapp.form_validation.domain.use_case.field_validation_use_case.PasswordFieldValidationUseCase
import c.m.storyapp.form_validation.presentation.event.FormValidationEvent
import c.m.storyapp.login.domain.use_case.user_login_use_case.UserLoginUseCase
import c.m.storyapp.login.presentation.event.InputLoginDataEvent
import c.m.storyapp.login.presentation.event.LoginUIStatusEvent
import c.m.storyapp.login.presentation.state.LoginUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userLoginUseCase: UserLoginUseCase,
    private val saveTokenToDataStoreUseCase: SaveTokenToDataStoreUseCase,
    private val emailFieldValidationUseCase: EmailFieldValidationUseCase,
    private val passwordFieldValidationUseCase: PasswordFieldValidationUseCase,
) : ViewModel() {
    private val _loginUIState = MutableStateFlow(LoginUIState())
    val loginUIState: StateFlow<LoginUIState> = _loginUIState.asStateFlow()

    private val inputLoginEventChannel = Channel<FormValidationEvent>()
    val inputLoginEvents = inputLoginEventChannel.receiveAsFlow()

    private val loginUIStatusEventChannel = Channel<LoginUIStatusEvent>()
    val loginUIStatusEvent = loginUIStatusEventChannel.receiveAsFlow()

    fun onInputFieldEvent(event: InputLoginDataEvent) {
        when (event) {
            is InputLoginDataEvent.EmailFieldChange -> _loginUIState.update {
                it.copy(email = event.email)
            }
            is InputLoginDataEvent.PasswordFieldChange -> _loginUIState.update {
                it.copy(password = event.password)
            }
            InputLoginDataEvent.SubmitUserLoginData -> submitUserLoginData()
            InputLoginDataEvent.CheckUserLoginData -> checkUserLoginData()
        }
    }

    private fun checkUserLoginData() {
        _loginUIState.update { it.copy(isLoading = true) }
        _loginUIState.update {
            it.copy(
                isLoading = false,
                email = _loginUIState.value.email,
                emailFieldError = null
            )
        }
        _loginUIState.update {
            it.copy(
                isLoading = false,
                password = _loginUIState.value.password,
                passwordFieldError = null
            )
        }

        val emailResult = emailFieldValidationUseCase(_loginUIState.value.email)
        val passwordResult = passwordFieldValidationUseCase(_loginUIState.value.password)
        val hasError = listOf(emailResult, passwordResult).any { !it.successful }

        if (hasError) {
            _loginUIState.update {
                it.copy(
                    isLoading = false,
                    errorMessage = UIText.StringResource(R.string.error_validation_login),
                    isError = true,
                    isSuccess = false,
                    emailFieldError = emailResult.errorMessage,
                    passwordFieldError = passwordResult.errorMessage
                )
            }

            return
        }

        // isLoading for UI State
        _loginUIState.update {
            it.copy(
                isLoading = true
            )
        }

        // event submit login data success
        viewModelScope.launch {
            inputLoginEventChannel.send(FormValidationEvent.Success)
        }
    }

    private fun submitUserLoginData() {
        viewModelScope.launch {
            userLoginUseCase(
                _loginUIState.value.email,
                _loginUIState.value.password
            ).collect { result ->
                when (result) {
                    is Resource.Error -> {
                        _loginUIState.update {
                            it.copy(
                                isLoading = false,
                                errorMessage = result.message,
                                isError = true,
                                isSuccess = false,
                            )
                        }
                        loginUIStatusEventChannel.send(LoginUIStatusEvent.Error)
                    }
                    is Resource.Loading -> {
                        _loginUIState.update {
                            it.copy(
                                isLoading = true,
                                isError = false,
                                isSuccess = false,
                            )
                        }
                    }
                    is Resource.Success -> {
                        _loginUIState.update {
                            it.copy(
                                isLoading = false,
                                isError = false,
                                isSuccess = true,
                            )
                        }
                        savingTokenAuthentication(result.data?.loginResult?.token ?: "")
                    }
                }
            }
        }
    }

    private fun savingTokenAuthentication(token: String) {
        viewModelScope.launch {
            saveTokenToDataStoreUseCase(token).collect { result ->
                when (result) {
                    is Resource.Error -> {
                        _loginUIState.update {
                            it.copy(
                                isLoading = false,
                                errorMessage = result.message,
                                isError = true
                            )
                        }
                        loginUIStatusEventChannel.send(LoginUIStatusEvent.Error)
                    }
                    is Resource.Loading -> {
                        _loginUIState.update { it.copy(isLoading = true, isError = false) }
                    }
                    is Resource.Success -> {
                        _loginUIState.update {
                            it.copy(
                                isLoading = false,
                                isSuccess = true,
                                isError = false
                            )
                        }
                    }
                }
            }
        }
    }
}