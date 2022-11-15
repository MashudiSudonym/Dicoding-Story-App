package c.m.storyapp.add_story.utils

import c.m.storyapp.add_story.presentation.state.AddStoryUIState

object AddStoryUIStateDataDummy {
    fun generateAddStoryUIStateSuccessStateDataDummy(): AddStoryUIState {
        return AddStoryUIState(
            isLoading = false,
            isSuccess = true,
            isError = false,
        )
    }
}