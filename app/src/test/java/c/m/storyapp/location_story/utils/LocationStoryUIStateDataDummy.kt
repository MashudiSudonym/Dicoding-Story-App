package c.m.storyapp.location_story.utils

import c.m.storyapp.location_story.domain.model.LocationStoryListStory
import c.m.storyapp.location_story.presentation.state.LocationStoryUIState

object LocationStoryUIStateDataDummy {
    private fun generateStoryWithLocation(): List<LocationStoryListStory> {
        val fakeStoryDTO = ArrayList<LocationStoryListStory>()

        for (i in 1..10) {
            val fakeStoryItem = LocationStoryListStory(
                id = "$i",
                name = "name item $i",
                description = "key $i",
                photoUrl = "https://story-api.dicoding.dev/images/stories/photos-1666969385959_OAqj0s4-.jpg",
                createdAt = "2022-10-28T15:03:05.963Z",
                latitude = 0.0,
                longitude = 0.0
            )

            fakeStoryDTO.add(fakeStoryItem)
        }

        return fakeStoryDTO
    }

    fun generateLocationStoryUIStateSuccessStateFakeData(): LocationStoryUIState {
        return LocationStoryUIState(
            isLoading = false,
            isSuccess = true,
            isError = false,
            locationStory = generateStoryWithLocation()
        )
    }
}