package c.m.storyapp.login.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import c.m.storyapp.authentication_check.domain.use_case.save_token_to_data_store_use_case.SaveTokenToDataStoreUseCase
import c.m.storyapp.common.domain.use_case.field_validation_use_case.EmailFieldValidationUseCase
import c.m.storyapp.common.domain.use_case.field_validation_use_case.PasswordFieldValidationUseCase
import c.m.storyapp.common.util.Resource
import c.m.storyapp.login.domain.use_case.user_login_use_case.UserLoginUseCase
import c.m.storyapp.login.presentation.state.LoginUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
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
    val loginUIState: StateFlow<LoginUIState> = _loginUIState

    fun submitLoginData(email: String, password: String) {
        _loginUIState.update { it.copy(isLoading = true) }
        _loginUIState.update { it.copy(isLoading = false, email = email, emailFieldError = null) }
        _loginUIState.update {
            it.copy(isLoading = false,
                password = password,
                passwordFieldError = null)
        }

        val emailResult = emailFieldValidationUseCase.execute(_loginUIState.value.email)
        val passwordResult = passwordFieldValidationUseCase.execute(_loginUIState.value.password)
        val hasError = listOf(emailResult, passwordResult).any { !it.successful }

        if (hasError) {
            _loginUIState.update {
                it.copy(
                    isLoading = false,
                    emailFieldError = emailResult.errorMessage,
                    passwordFieldError = passwordResult.errorMessage,
                )
            }
        } else {
            // user login process
            viewModelScope.launch {
                userLoginUseCase(_loginUIState.value.email,
                    _loginUIState.value.password).collect { result ->
                    when (result) {
                        is Resource.Error -> {
                            _loginUIState.update {
                                it.copy(isLoading = false,
                                    errorMessage = result.message,
                                    isError = true)
                            }
                        }
                        is Resource.Loading -> {
                            _loginUIState.update { it.copy(isLoading = true, isError = false) }
                        }
                        is Resource.Success -> {
                            _loginUIState.update { it.copy(isLoading = false, isError = false) }

                            // Saving token authentication
                            viewModelScope.launch {
                                saveTokenToDataStoreUseCase(result.data?.loginResult?.token
                                    ?: "").collect { result ->
                                    when (result) {
                                        is Resource.Error -> {
                                            _loginUIState.update {
                                                it.copy(isLoading = false,
                                                    errorMessage = result.message,
                                                    isError = true)
                                            }
                                        }
                                        is Resource.Loading -> {
                                            _loginUIState.update {
                                                it.copy(isLoading = true,
                                                    isError = false)
                                            }
                                        }
                                        is Resource.Success -> {
                                            _loginUIState.update {
                                                it.copy(isLoading = false,
                                                    isSuccess = true,
                                                    isError = false)
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}