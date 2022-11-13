package c.m.storyapp.list_story.domain.use_case.show_list_story_use_case

import androidx.paging.PagingData
import c.m.storyapp.common.util.Resource
import c.m.storyapp.list_story.domain.model.Story
import c.m.storyapp.list_story.domain.repository.ListStoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ShowListStoryUseCase @Inject constructor(private val listStoryRepository: ListStoryRepository) {
    suspend operator fun invoke(token: String): Flow<Resource<Flow<PagingData<Story>>>> {
        return listStoryRepository.getListStory(token)
    }
}