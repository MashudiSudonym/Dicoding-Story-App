package c.m.storyapp.list_story.data.mapper

import c.m.storyapp.list_story.data.remote.dto.ListStoryDTO
import c.m.storyapp.list_story.data.remote.dto.ListStoryResponseDTO
import c.m.storyapp.list_story.domain.model.ListStory
import c.m.storyapp.list_story.domain.model.ListStoryResponse

fun ListStoryResponseDTO.toListStoryResponse(): ListStoryResponse {
    return ListStoryResponse(
        error = error,
        message = message,
        listStory = listStory.map { it.toListStory() }
    )
}

fun ListStoryDTO.toListStory(): ListStory {
    return ListStory(
        id = id,
        name = name,
        description = description,
        photoUrl = photoUrl,
        createdAt = createdAt,
    )
}