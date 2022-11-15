package c.m.storyapp.location_story.presentation.view_model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import c.m.storyapp.MainDispatcherRule
import c.m.storyapp.authentication_check.domain.use_case.get_token_from_data_store_use_case.GetTokenFromDataStoreUseCase
import c.m.storyapp.authentication_check.utils.FakeAuthenticationCheckRepository
import c.m.storyapp.location_story.domain.use_case.show_location_story_use_case.ShowLocationStoryUseCase
import c.m.storyapp.location_story.utils.FakeLocationStoryRepository
import c.m.storyapp.location_story.utils.LocationStoryUIStateDataDummy
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class LocationStoryViewModelTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var fakeLocationStoryRepository: FakeLocationStoryRepository
    private lateinit var fakeAuthenticationCheckRepository: FakeAuthenticationCheckRepository
    private lateinit var showLocationStoryUseCase: ShowLocationStoryUseCase
    private lateinit var getTokenFromDataStoreUseCase: GetTokenFromDataStoreUseCase
    private lateinit var locationStoryViewModel: LocationStoryViewModel

    @Before
    fun setUp() {
        fakeLocationStoryRepository = FakeLocationStoryRepository()
        fakeAuthenticationCheckRepository = FakeAuthenticationCheckRepository()
        showLocationStoryUseCase = ShowLocationStoryUseCase(fakeLocationStoryRepository)
        getTokenFromDataStoreUseCase =
            GetTokenFromDataStoreUseCase(fakeAuthenticationCheckRepository)

        locationStoryViewModel =
            LocationStoryViewModel(showLocationStoryUseCase, getTokenFromDataStoreUseCase)
    }

    @Test
    fun `get location story success data`() = runTest {
        locationStoryViewModel

        val expectedResult =
            LocationStoryUIStateDataDummy.generateLocationStoryUIStateSuccessStateFakeData().isSuccess
        val currentResult = locationStoryViewModel.locationStoryUIState.value.isSuccess

        assertEquals(expectedResult, currentResult)
    }
}