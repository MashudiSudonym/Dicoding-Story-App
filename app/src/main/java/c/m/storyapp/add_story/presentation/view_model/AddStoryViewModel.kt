package c.m.storyapp.add_story.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import c.m.storyapp.add_story.domain.use_case.add_story_use_case.AddStoryUseCase
import c.m.storyapp.add_story.presentation.state.AddStoryUIState
import c.m.storyapp.authentication_check.domain.use_case.get_token_from_data_store_use_case.GetTokenFromDataStoreUseCase
import c.m.storyapp.common.util.Resource
import c.m.storyapp.form_validation.domain.use_case.field_validation_use_case.DescriptionFieldValidationUseCase
import c.m.storyapp.form_validation.domain.use_case.field_validation_use_case.PhotoFieldValidationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AddStoryViewModel @Inject constructor(
    private val addStoryUseCase: AddStoryUseCase,
    private val getTokenFromDataStoreUseCase: GetTokenFromDataStoreUseCase,
    private val descriptionFieldValidationUseCase: DescriptionFieldValidationUseCase,
    private val photoFieldValidationUseCase: PhotoFieldValidationUseCase,
) : ViewModel() {
    private val _addStoryUIState = MutableStateFlow(AddStoryUIState())
    val addStoryUIState: StateFlow<AddStoryUIState> = _addStoryUIState

    fun postStory(photo: File, description: String) {
        _addStoryUIState.update { it.copy(isLoading = true) }
        _addStoryUIState.update {
            it.copy(
                isLoading = false,
                description = description,
                descriptionFieldError = null
            )
        }
        _addStoryUIState.update {
            it.copy(isLoading = false, photo = photo, photoFieldError = null)
        }

        val photoResult = photoFieldValidationUseCase(_addStoryUIState.value.photo as File)
        val descriptionResult =
            descriptionFieldValidationUseCase(_addStoryUIState.value.description)
        val hasError = listOf(photoResult, descriptionResult).any { !it.successful }

        if (hasError) {
            _addStoryUIState.update {
                it.copy(
                    isLoading = false,
                    descriptionFieldError = descriptionResult.errorMessage,
                    photoFieldError = photoResult.errorMessage
                )
            }
        } else {
            uploadStoryProcess()
        }
    }

    private fun uploadStoryProcess() {
        viewModelScope.launch {
            getTokenFromDataStoreUseCase().collect { tokenResult ->
                when (tokenResult) {
                    is Resource.Error -> {
                        _addStoryUIState.update {
                            it.copy(
                                isLoading = false,
                                isError = true,
                                isSuccess = false,
                                errorMessage = tokenResult.message
                            )
                        }
                    }
                    is Resource.Loading -> {
                        _addStoryUIState.update {
                            it.copy(
                                isLoading = true,
                                isError = false,
                                isSuccess = false,
                                errorMessage = null
                            )
                        }
                    }
                    is Resource.Success -> {
                        viewModelScope.launch {
                            addStoryUseCase(
                                tokenResult.data?.token ?: "",
                                _addStoryUIState.value.photo as File,
                                _addStoryUIState.value.description,
                            ).collect { result ->
                                when (result) {
                                    is Resource.Error -> {
                                        _addStoryUIState.update {
                                            it.copy(
                                                isLoading = false,
                                                isError = true,
                                                isSuccess = false,
                                                errorMessage = result.message
                                            )
                                        }
                                    }
                                    is Resource.Loading -> {
                                        _addStoryUIState.update {
                                            it.copy(
                                                isLoading = true,
                                                isError = false,
                                                isSuccess = false,
                                                errorMessage = null
                                            )
                                        }
                                    }
                                    is Resource.Success -> {
                                        Timber.d(result.data?.message ?: "nothing")

                                        _addStoryUIState.update {
                                            it.copy(
                                                isLoading = false,
                                                isError = false,
                                                isSuccess = true,
                                                errorMessage = null
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