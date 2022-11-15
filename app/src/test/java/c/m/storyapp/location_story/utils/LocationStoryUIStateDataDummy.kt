package c.m.storyapp.location_story.utils

import c.m.storyapp.location_story.presentation.state.LocationStoryUIState

object LocationStoryUIStateDataDummy {
    fun generateLocationStoryUIStateSuccessStateFakeData(): LocationStoryUIState {
        return LocationStoryUIState(
            isLoading = false,
            isSuccess = true,
            isError = false,
        )
    }
}