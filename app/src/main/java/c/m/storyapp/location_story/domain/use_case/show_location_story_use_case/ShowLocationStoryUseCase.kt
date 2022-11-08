package c.m.storyapp.location_story.domain.use_case.show_location_story_use_case

import c.m.storyapp.common.util.Resource
import c.m.storyapp.location_story.domain.model.LocationStoryResponse
import c.m.storyapp.location_story.domain.repository.LocationStoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ShowLocationStoryUseCase @Inject constructor(private val locationStoryRepository: LocationStoryRepository) {
    suspend operator fun invoke(token: String): Flow<Resource<LocationStoryResponse>> {
        return locationStoryRepository.getLocationStory(token)
    }
}