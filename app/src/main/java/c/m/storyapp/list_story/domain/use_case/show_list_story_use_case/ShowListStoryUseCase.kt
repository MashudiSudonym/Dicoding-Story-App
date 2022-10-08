package c.m.storyapp.list_story.domain.use_case.show_list_story_use_case

import c.m.storyapp.common.util.Resource
import c.m.storyapp.list_story.domain.model.ListStoryResponse
import c.m.storyapp.list_story.domain.repository.ListStoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ShowListStoryUseCase @Inject constructor(private val listStoryRepository: ListStoryRepository) {
    suspend operator fun invoke(token: String): Flow<Resource<ListStoryResponse>> {
        return listStoryRepository.getListStory(token)
    }
}