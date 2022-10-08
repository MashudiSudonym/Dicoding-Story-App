package c.m.storyapp.list_story.domain.model

data class ListStoryResponse(
    val error: Boolean,
    val message: String,
    val listStory: List<ListStory>,
)
