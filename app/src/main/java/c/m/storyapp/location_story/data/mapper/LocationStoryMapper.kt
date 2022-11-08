package c.m.storyapp.location_story.data.mapper

import c.m.storyapp.location_story.data.remote.dto.LocationStoryListStoryDTO
import c.m.storyapp.location_story.data.remote.dto.LocationStoryResponseDTO
import c.m.storyapp.location_story.domain.model.LocationStoryListStory
import c.m.storyapp.location_story.domain.model.LocationStoryResponse

fun LocationStoryResponseDTO.toLocationStoryResponse(): LocationStoryResponse {
    return LocationStoryResponse(
        error = error,
        message = message,
        locationStoryListStory = locationStoryListStory.map { it.toLocationStoryListStory() }
    )
}

fun LocationStoryListStoryDTO.toLocationStoryListStory(): LocationStoryListStory {
    return LocationStoryListStory(
        id = id,
        name = name,
        description = description,
        photoUrl = photoUrl,
        createdAt = createdAt,
        latitude = latitude,
        longitude = longitude,
    )
}