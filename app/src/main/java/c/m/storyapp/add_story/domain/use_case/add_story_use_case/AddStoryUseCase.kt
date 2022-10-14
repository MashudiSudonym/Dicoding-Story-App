package c.m.storyapp.add_story.domain.use_case.add_story_use_case

import c.m.storyapp.add_story.domain.model.AddStoryResponse
import c.m.storyapp.add_story.domain.repository.AddStoryRepository
import c.m.storyapp.common.util.Constants
import c.m.storyapp.common.util.Resource
import kotlinx.coroutines.flow.Flow
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import javax.inject.Inject

class AddStoryUseCase @Inject constructor(private val addStoryRepository: AddStoryRepository) {
    suspend operator fun invoke(
        token: String,
        photo: File,
        description: String,
    ): Flow<Resource<AddStoryResponse>> {
        val contentDescription = description.toRequestBody(Constants.TEXT_PLAIN.toMediaType())
        val contentPhoto = photo.asRequestBody(Constants.IMAGE_JPEG.toMediaTypeOrNull())
        val photoMultiPart: MultipartBody.Part =
            MultipartBody.Part.createFormData(Constants.PHOTO, photo.name, contentPhoto)

        return addStoryRepository.postStory(token, photoMultiPart, contentDescription)
    }
}