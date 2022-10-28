package c.m.storyapp.list_story.utils

import c.m.storyapp.list_story.data.remote.dto.ListStoryDTO
import c.m.storyapp.list_story.data.remote.dto.ListStoryResponseDTO

object ListStoryDataDummy {
    private fun generateListStoryFakeDataDTO(): List<ListStoryDTO> {
        val fakeListStoryDTO = ArrayList<ListStoryDTO>()

        for (i in 1..10) {
            val fakeStoryItem = ListStoryDTO(
                id = "$i",
                name = "name item $i",
                description = "key $i",
                photoUrl = "https://story-api.dicoding.dev/images/stories/photos-1666969385959_OAqj0s4-.jpg",
                createdAt = "2022-10-28T15:03:05.963Z",
                latitude = i.toDouble(),
                longitude = i.toDouble(),
            )

            fakeListStoryDTO.add(fakeStoryItem)
        }

        return fakeListStoryDTO
    }

    fun generateListStoryFakeDataResponseDTO(): ListStoryResponseDTO {
        val fakeListStoryDTO = generateListStoryFakeDataDTO()
        val fakeListStoryReponseDTO = ListStoryResponseDTO(
            error = false,
            message = "Stories fetched successfully",
            listStory = fakeListStoryDTO
        )

        return fakeListStoryReponseDTO
    }
}