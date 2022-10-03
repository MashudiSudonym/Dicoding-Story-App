package c.m.storyapp.authentication_check.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import c.m.storyapp.authentication_check.domain.use_case.check_authentication_status_use_case.CheckAuthenticationStatusUseCase
import c.m.storyapp.authentication_check.presentation.state.AuthenticationCheckUIState
import c.m.storyapp.common.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationCheckViewModel @Inject constructor(private val checkAuthenticationStatusUseCase: CheckAuthenticationStatusUseCase) :
    ViewModel() {
    private val _authenticationCheckUIState = MutableStateFlow(AuthenticationCheckUIState())
    val authenticationCheckUIState: StateFlow<AuthenticationCheckUIState> =
        _authenticationCheckUIState

    init {
        isAuthenticated()
    }

    // function or method for check user is authenticated or not
    private fun isAuthenticated() {
        viewModelScope.launch {
            checkAuthenticationStatusUseCase().collect { result ->
                when (result) {
                    is Resource.Error -> {
                        _authenticationCheckUIState.update {
                            it.copy(isError = true,
                                isLoading = false,
                                isAuthenticated = false)
                        }
                    }
                    is Resource.Loading -> {
                        _authenticationCheckUIState.update {
                            it.copy(isLoading = result.isLoading,
                                isError = false,
                                isAuthenticated = false)
                        }
                    }
                    is Resource.Success -> {
                        _authenticationCheckUIState.update {
                            it.copy(isAuthenticated = result.data?.isAuthenticated ?: false)
                        }
                    }
                }
            }
        }
    }
}