package c.m.storyapp.location_story.domain.model

data class LocationStoryResponse(
    val error: Boolean,
    val message: String,
    val locationStoryListStory: List<LocationStoryListStory>,
)
