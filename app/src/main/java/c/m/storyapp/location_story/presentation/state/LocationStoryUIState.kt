package c.m.storyapp.location_story.presentation.state

import c.m.storyapp.common.util.UIText
import c.m.storyapp.location_story.domain.model.LocationStoryListStory

data class LocationStoryUIState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val isSuccess: Boolean = false,
    val errorMessage: UIText? = null,
    val locationStory: List<LocationStoryListStory> = listOf(),
)
