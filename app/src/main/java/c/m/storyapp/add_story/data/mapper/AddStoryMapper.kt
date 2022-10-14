package c.m.storyapp.add_story.data.mapper

import c.m.storyapp.add_story.data.remote.dto.AddStoryResponseDTO
import c.m.storyapp.add_story.domain.model.AddStoryResponse

fun AddStoryResponseDTO.toAddStoryResponse(): AddStoryResponse {
    return AddStoryResponse(
        error = error,
        message = message
    )
}