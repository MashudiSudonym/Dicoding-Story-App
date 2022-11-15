package c.m.storyapp.location_story.utils

import c.m.storyapp.location_story.data.remote.dto.LocationStoryListStoryDTO
import c.m.storyapp.location_story.data.remote.dto.LocationStoryResponseDTO

object LocationStoryDataDummy {
    private fun generateLocationStoryFakeDataDTO(): List<LocationStoryListStoryDTO> {
        val fakeStoryDTO = ArrayList<LocationStoryListStoryDTO>()

        for (i in 1..10) {
            val fakeStoryItem = LocationStoryListStoryDTO(
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

    fun generateLocationStoryFakeDataResponseDTO(): LocationStoryResponseDTO {
        val fakeListStoryDTO = generateLocationStoryFakeDataDTO()

        return LocationStoryResponseDTO(
            error = false,
            message = "Stories fetched successfully",
            locationStoryListStory = fakeListStoryDTO
        )
    }
}