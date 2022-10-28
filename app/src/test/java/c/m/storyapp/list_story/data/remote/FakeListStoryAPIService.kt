package c.m.storyapp.list_story.data.remote

import c.m.storyapp.list_story.data.remote.dto.ListStoryResponseDTO
import c.m.storyapp.list_story.utils.ListStoryDataDummy

class FakeListStoryAPIService : ListStoryAPI {
    private val fakeListStoryResponseDTO = ListStoryDataDummy.generateListStoryFakeDataResponseDTO()

    override suspend fun getListStory(token: String): ListStoryResponseDTO {
        return fakeListStoryResponseDTO
    }
}