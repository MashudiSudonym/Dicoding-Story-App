package c.m.storyapp.add_story.presentation.view_model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import c.m.storyapp.MainDispatcherRule
import c.m.storyapp.add_story.domain.use_case.add_story_use_case.AddStoryUseCase
import c.m.storyapp.add_story.utils.AddStoryUIStateDataDummy
import c.m.storyapp.add_story.utils.FakeAddStoryRepository
import c.m.storyapp.authentication_check.domain.use_case.get_token_from_data_store_use_case.GetTokenFromDataStoreUseCase
import c.m.storyapp.authentication_check.utils.FakeAuthenticationCheckRepository
import c.m.storyapp.form_validation.domain.use_case.field_validation_use_case.DescriptionFieldValidationUseCase
import c.m.storyapp.form_validation.domain.use_case.field_validation_use_case.PhotoFieldValidationUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import java.io.File

@ExperimentalCoroutinesApi
class AddStoryViewModelTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var fakeAddStoryRepository: FakeAddStoryRepository
    private lateinit var fakeAuthenticationCheckRepository: FakeAuthenticationCheckRepository
    private lateinit var addStoryUseCase: AddStoryUseCase
    private lateinit var getTokenFromDataStoreUseCase: GetTokenFromDataStoreUseCase
    private lateinit var descriptionFieldValidationUseCase: DescriptionFieldValidationUseCase
    private lateinit var photoFieldValidationUseCase: PhotoFieldValidationUseCase
    private lateinit var addStoryViewModel: AddStoryViewModel

    @Before
    fun setUp() {
        fakeAddStoryRepository = FakeAddStoryRepository()
        fakeAuthenticationCheckRepository = FakeAuthenticationCheckRepository()
        addStoryUseCase = AddStoryUseCase(fakeAddStoryRepository)
        getTokenFromDataStoreUseCase =
            GetTokenFromDataStoreUseCase(fakeAuthenticationCheckRepository)
        descriptionFieldValidationUseCase = DescriptionFieldValidationUseCase()
        photoFieldValidationUseCase = PhotoFieldValidationUseCase()

        addStoryViewModel = AddStoryViewModel(
            addStoryUseCase,
            getTokenFromDataStoreUseCase,
            descriptionFieldValidationUseCase,
            photoFieldValidationUseCase
        )
    }

    @Test
    fun `post story success`() = runTest {
        val mockFile: File = mock { on { absolutePath } doReturn "/random" }

        addStoryViewModel.postStory(mockFile, "description")

        val expectedResult =
            AddStoryUIStateDataDummy.generateAddStoryUIStateSuccessStateDataDummy().isSuccess
        val currentResult = addStoryViewModel.addStoryUIState.value.isSuccess

        assertEquals(expectedResult, currentResult)
    }
}