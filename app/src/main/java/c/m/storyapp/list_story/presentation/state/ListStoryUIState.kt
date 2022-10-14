package c.m.storyapp.list_story.presentation.state

import c.m.storyapp.common.util.UIText
import c.m.storyapp.list_story.domain.model.ListStory

data class ListStoryUIState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val isSuccess: Boolean = false,
    val errorMessage: UIText? = null,
    val listStory: List<ListStory> = listOf(),
    val isLogout: Boolean = false,
)
