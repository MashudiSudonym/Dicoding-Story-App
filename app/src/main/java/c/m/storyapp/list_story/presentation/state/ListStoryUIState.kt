package c.m.storyapp.list_story.presentation.state

import androidx.paging.PagingData
import c.m.storyapp.common.util.UIText
import c.m.storyapp.list_story.domain.model.Story

data class ListStoryUIState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val isSuccess: Boolean = false,
    val errorMessage: UIText? = null,
    val story: PagingData<Story> = PagingData.empty(),
    val isLogout: Boolean = false,
)
