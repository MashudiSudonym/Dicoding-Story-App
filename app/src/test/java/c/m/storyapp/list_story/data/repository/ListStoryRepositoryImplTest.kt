package c.m.storyapp.list_story.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import c.m.storyapp.MainDispatcherRule
import c.m.storyapp.list_story.data.mapper.toListStoryResponse
import c.m.storyapp.list_story.data.remote.FakeListStoryAPIService
import c.m.storyapp.list_story.domain.repository.ListStoryRepository
import c.m.storyapp.list_story.utils.ListStoryDataDummy
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ListStoryRepositoryImplTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var fakeListStoryAPIService: FakeListStoryAPIService
    private lateinit var listStoryRepository: ListStoryRepository

    @Before
    fun setUp() {
        fakeListStoryAPIService = FakeListStoryAPIService()
        listStoryRepository = ListStoryRepositoryImpl(fakeListStoryAPIService)
    }

    @Test
    fun `when getListStory Should Not Null`() = runTest {
        val actualListStory = listStoryRepository.getListStory("").last().data

        assertNotNull(actualListStory)
    }

    @Test
    fun `when getListStory Contain Actual Data Equals Fake Data`() = runTest {
        val expectedListStory =
            ListStoryDataDummy.generateListStoryFakeDataResponseDTO().toListStoryResponse()
        val actualListStory = listStoryRepository.getListStory("").last().data

        assertEquals(expectedListStory.listStory, actualListStory?.listStory)
    }
}