package c.m.storyapp.list_story.data.mapper

import c.m.storyapp.list_story.data.remote.dto.ListStoryResponseDTO
import c.m.storyapp.list_story.data.remote.dto.StoryDTO
import c.m.storyapp.list_story.domain.model.ListStoryResponse
import c.m.storyapp.list_story.domain.model.Story

fun ListStoryResponseDTO.toListStoryResponse(): ListStoryResponse {
    return ListStoryResponse(
        error = error,
        message = message,
        listStory = listStory?.map { it.toStory() }
    )
}

fun StoryDTO.toStory(): Story {
    return Story(
        id = id,
        name = name,
        description = description,
        photoUrl = photoUrl,
        createdAt = createdAt,
    )
}