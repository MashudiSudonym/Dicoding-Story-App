package c.m.storyapp.list_story.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import c.m.storyapp.authentication_check.domain.use_case.get_token_from_data_store_use_case.GetTokenFromDataStoreUseCase
import c.m.storyapp.common.util.Resource
import c.m.storyapp.list_story.domain.use_case.show_list_story_use_case.ShowListStoryUseCase
import c.m.storyapp.list_story.presentation.state.ListStoryUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListStoryViewModel @Inject constructor(
    private val getTokenFromDataStoreUseCase: GetTokenFromDataStoreUseCase,
    private val getListStoryUseCase: ShowListStoryUseCase,
) : ViewModel() {
    private val _listStoryUIState = MutableStateFlow(ListStoryUIState())
    val listStoryUIState: StateFlow<ListStoryUIState> = _listStoryUIState

    init {
        getListStory()
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
                        viewModelScope.launch {
                            getListStoryUseCase(tokenResult.data?.token ?: "").collect { result ->
                                when (result) {
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
                                        _listStoryUIState.update {
                                            it.copy(
                                                isLoading = false,
                                                isError = false,
                                                isSuccess = true,
                                                errorMessage = null,
                                                listStory = result.data?.listStory ?: listOf()
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