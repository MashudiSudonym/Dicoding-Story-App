package c.m.storyapp.list_story.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import c.m.storyapp.authentication_check.domain.use_case.get_token_from_data_store_use_case.GetTokenFromDataStoreUseCase
import c.m.storyapp.authentication_check.domain.use_case.logout_use_case.LogoutUseCase
import c.m.storyapp.common.util.Resource
import c.m.storyapp.list_story.domain.use_case.show_list_story_use_case.ShowListStoryUseCase
import c.m.storyapp.list_story.presentation.state.ListStoryUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ListStoryViewModel @Inject constructor(
    private val getTokenFromDataStoreUseCase: GetTokenFromDataStoreUseCase,
    private val getListStoryUseCase: ShowListStoryUseCase,
    private val logoutUseCase: LogoutUseCase,
) : ViewModel() {
    private val _listStoryUIState = MutableStateFlow(ListStoryUIState())
    val listStoryUIState: StateFlow<ListStoryUIState> = _listStoryUIState

    init {
        getListStory()
    }

    fun logout() {
        viewModelScope.launch {
            logoutUseCase().collect { result ->
                when (result) {
                    is Resource.Error -> {
                        _listStoryUIState.update {
                            it.copy(
                                isLoading = false,
                                isError = true,
                                isSuccess = false,
                                errorMessage = result.message,
                            )
                        }
                    }
                    is Resource.Loading -> {
                        _listStoryUIState.update {
                            it.copy(
                                isLoading = true,
                                isError = false,
                                isSuccess = false,
                                errorMessage = null,
                            )
                        }
                    }
                    is Resource.Success -> {
                        _listStoryUIState.update {
                            it.copy(
                                isLoading = false,
                                isError = false,
                                isSuccess = true,
                                errorMessage = null,
                                isLogout = true
                            )
                        }
                    }
                }
            }
        }
    }

    private fun getListStory() {
        viewModelScope.launch {
            getTokenFromDataStoreUseCase().collect { tokenResult ->
                when (tokenResult) {
                    is Resource.Error -> {
                        _listStoryUIState.update {
                            it.copy(
                                isLoading = false,
                                isError = true,
                                isSuccess = false,
                                errorMessage = tokenResult.message,
                            )
                        }
                    }
                    is Resource.Loading -> {
                        _listStoryUIState.update {
                            it.copy(
                                isLoading = true,
                                isError = false,
                                isSuccess = false,
                                errorMessage = null,
                            )
                        }
                    }
                    is Resource.Success -> {

                        Timber.w("${tokenResult.data?.token}")

                        viewModelScope.launch {
                            getListStoryUseCase(tokenResult.data?.token
                                ?: "").collectLatest { result ->
                                when (result) {
                                    is Resource.Error -> {
                                        _listStoryUIState.update {
                                            it.copy(
                                                isLoading = false,
                                                isError = true,
                                                isSuccess = false,
                                                errorMessage = result.message,
                                            )
                                        }
                                    }
                                    is Resource.Loading -> {
                                        _listStoryUIState.update {
                                            it.copy(
                                                isLoading = true,
                                                isError = false,
                                                isSuccess = false,
                                                errorMessage = null,
                                            )
                                        }
                                    }
                                    is Resource.Success -> {
                                        result.data?.collectLatest { pagingData ->
                                            _listStoryUIState.update {
                                                it.copy(
                                                    isLoading = false,
                                                    isError = false,
                                                    isSuccess = true,
                                                    errorMessage = null,
                                                    story = pagingData,
                                                )
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