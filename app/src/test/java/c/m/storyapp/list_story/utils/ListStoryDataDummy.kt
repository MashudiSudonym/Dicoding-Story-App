package c.m.storyapp.list_story.utils

import c.m.storyapp.list_story.data.remote.dto.ListStoryResponseDTO
import c.m.storyapp.list_story.data.remote.dto.StoryDTO

object ListStoryDataDummy {
    private fun generateListStoryFakeDataDTO(): List<StoryDTO> {
        val fakeStoryDTO = ArrayList<StoryDTO>()

        for (i in 1..10) {
            val fakeStoryItem = StoryDTO(
                id = "$i",
                name = "name item $i",
                description = "key $i",
                photoUrl = "https://story-api.dicoding.dev/images/stories/photos-1666969385959_OAqj0s4-.jpg",
                createdAt = "2022-10-28T15:03:05.963Z",
            )

            fakeStoryDTO.add(fakeStoryItem)
        }

        return fakeStoryDTO
    }

    fun generateListStoryFakeDataResponseDTO(): ListStoryResponseDTO {
        val fakeListStoryDTO = generateListStoryFakeDataDTO()

        return ListStoryResponseDTO(
            error = false,
            message = "Stories fetched successfully",
            listStory = fakeListStoryDTO
        )
    }
}