package c.m.storyapp.add_story.utils

import c.m.storyapp.add_story.data.remote.dto.AddStoryResponseDTO

object AddStoryDataDummy {
    fun generateAddStoryResponseDTODataDummy(): AddStoryResponseDTO {
        return AddStoryResponseDTO(
            error = false,
            message = "success"
        )
    }
}