package c.m.storyapp.location_story.domain.model

data class LocationStoryListStory(
    val id: String,
    val name: String,
    val description: String,
    val photoUrl: String,
    val createdAt: String,
    val latitude: Double,
    val longitude: Double,
)
