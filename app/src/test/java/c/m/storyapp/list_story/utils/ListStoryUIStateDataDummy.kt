package c.m.storyapp.list_story.utils

import c.m.storyapp.list_story.presentation.state.ListStoryUIState

object ListStoryUIStateDataDummy {
    fun generateListStoryUIStateSuccessStateDataDummy(): ListStoryUIState {
        return ListStoryUIState(
            isLoading = false,
            isError = false,
            isSuccess = true,
        )
    }

    fun generateLostStoryUIStateLogoutSuccessStateDataDummy(): ListStoryUIState {
        return ListStoryUIState(
            isLoading = false,
            isError = false,
            isSuccess = true,
            isLogout = true
        )
    }
}