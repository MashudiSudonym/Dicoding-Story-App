package c.m.storyapp.list_story.presentation.view_model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import c.m.storyapp.MainDispatcherRule
import c.m.storyapp.authentication_check.domain.use_case.get_token_from_data_store_use_case.GetTokenFromDataStoreUseCase
import c.m.storyapp.authentication_check.domain.use_case.logout_use_case.LogoutUseCase
import c.m.storyapp.authentication_check.utils.FakeAuthenticationCheckRepository
import c.m.storyapp.list_story.domain.use_case.show_list_story_use_case.ShowListStoryUseCase
import c.m.storyapp.list_story.utils.FakeListStoryRepository
import c.m.storyapp.list_story.utils.ListStoryUIStateDataDummy
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ListStoryViewModelTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var fakeListStoryRepository: FakeListStoryRepository
    private lateinit var fakeAuthenticationCheckRepository: FakeAuthenticationCheckRepository
    private lateinit var getTokenFromDataStoreUseCase: GetTokenFromDataStoreUseCase
    private lateinit var showListStoryUseCase: ShowListStoryUseCase
    private lateinit var logoutUseCase: LogoutUseCase
    private lateinit var listStoryViewModel: ListStoryViewModel

    @Before
    fun setUp() {
        fakeListStoryRepository = FakeListStoryRepository()
        fakeAuthenticationCheckRepository = FakeAuthenticationCheckRepository()
        getTokenFromDataStoreUseCase =
            GetTokenFromDataStoreUseCase(fakeAuthenticationCheckRepository)
        showListStoryUseCase = ShowListStoryUseCase(fakeListStoryRepository)
        logoutUseCase = LogoutUseCase(fakeAuthenticationCheckRepository)
        listStoryViewModel =
            ListStoryViewModel(getTokenFromDataStoreUseCase, showListStoryUseCase, logoutUseCase)
    }

    @Test
    fun `get list story success`() = runTest {
        listStoryViewModel

        val expectedResult =
            ListStoryUIStateDataDummy.generateListStoryUIStateSuccessStateDataDummy().isSuccess
        val currentResult = listStoryViewModel.listStoryUIState.value.isSuccess

        assertEquals(expectedResult, currentResult)
    }

    @Test
    fun `logout user success`() = runTest {
        listStoryViewModel.logout()

        val expectedResult =
            ListStoryUIStateDataDummy.generateListStoryUIStateSuccessStateDataDummy().isSuccess
        val currentResult = listStoryViewModel.listStoryUIState.value.isSuccess

        assertEquals(expectedResult, currentResult)
    }
}