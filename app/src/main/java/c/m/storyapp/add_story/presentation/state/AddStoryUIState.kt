package c.m.storyapp.add_story.presentation.state

import c.m.storyapp.common.util.UIText
import java.io.File

data class AddStoryUIState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val isSuccess: Boolean = false,
    val errorMessage: UIText? = null,
    val description: String = "",
    val descriptionFieldError: UIText? = null,
    val photo: File? = null,
    val photoFieldError: UIText? = null,
)
