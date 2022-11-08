package c.m.storyapp.location_story.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import c.m.storyapp.authentication_check.domain.use_case.get_token_from_data_store_use_case.GetTokenFromDataStoreUseCase
import c.m.storyapp.common.util.Resource
import c.m.storyapp.location_story.domain.use_case.show_location_story_use_case.ShowLocationStoryUseCase
import c.m.storyapp.location_story.presentation.state.LocationStoryUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationStoryViewModel @Inject constructor(
    private val getLocationStoryUseCase: ShowLocationStoryUseCase,
    private val getTokenFromDataStoreUseCase: GetTokenFromDataStoreUseCase,
) : ViewModel() {
    private val _locationStoryUIState = MutableStateFlow(LocationStoryUIState())
    val locationStoryUIState: StateFlow<LocationStoryUIState> = _locationStoryUIState

    init {
        getLocationStory()
    }

    private fun getLocationStory() {
        viewModelScope.launch {
            getTokenFromDataStoreUseCase().collect { tokenResult ->
                when (tokenResult) {
                    is Resource.Error -> {
                        _locationStoryUIState.update {
                            it.copy(
                                isLoading = false,
                                isError = true,
                                isSuccess = false,
                                errorMessage = tokenResult.message,
                            )
                        }
                    }
                    is Resource.Loading -> {
                        _locationStoryUIState.update {
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
                            getLocationStoryUseCase(tokenResult.data?.token
                                ?: "").collect { result ->
                                when (result) {
                                    is Resource.Error -> {
                                        _locationStoryUIState.update {
                                            it.copy(
                                                isLoading = false,
                                                isError = true,
                                                isSuccess = false,
                                                errorMessage = result.message,
                                            )
                                        }
                                    }
                                    is Resource.Loading -> {
                                        _locationStoryUIState.update {
                                            it.copy(
                                                isLoading = true,
                                                isError = false,
                                                isSuccess = false,
                                                errorMessage = null,
                                            )
                                        }
                                    }
                                    is Resource.Success -> {
                                        _locationStoryUIState.update {
                                            it.copy(
                                                isLoading = false,
                                                isError = false,
                                                isSuccess = true,
                                                errorMessage = null,
                                                locationStory = result.data?.locationStoryListStory
                                                    ?: listOf()
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