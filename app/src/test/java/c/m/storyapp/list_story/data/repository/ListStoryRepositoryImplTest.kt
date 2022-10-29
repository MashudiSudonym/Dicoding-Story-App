package c.m.storyapp.list_story.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import c.m.storyapp.MainDispatcherRule
import c.m.storyapp.list_story.data.remote.ListStoryAPI
import c.m.storyapp.list_story.data.remote.dto.ListStoryResponseDTO
import c.m.storyapp.list_story.domain.repository.ListStoryRepository
import c.m.storyapp.list_story.utils.ListStoryDataDummy
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.SocketPolicy
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@ExperimentalCoroutinesApi
class ListStoryRepositoryImplTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var listStoryRepository: ListStoryRepository
    private lateinit var mockWebServer: MockWebServer
    private lateinit var client: OkHttpClient
    private lateinit var apiService: ListStoryAPI
    private lateinit var dummyListStory: ListStoryResponseDTO

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start()

        client = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .writeTimeout(1, TimeUnit.SECONDS)
            .build()

        apiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ListStoryAPI::class.java)

        listStoryRepository = ListStoryRepositoryImpl(apiService)

        dummyListStory = ListStoryDataDummy.generateListStoryFakeDataResponseDTO()
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `when getListStory Should Not Null`() = runTest {
        val expectedResponse =
            MockResponse().setResponseCode(200).setBody(Gson().toJson(dummyListStory))

        mockWebServer.enqueue(expectedResponse)

        val actualResponse = listStoryRepository.getListStory("").last().data

        assertNotNull(actualResponse)
    }

    @Test
    fun `when getListStory Should Empty List With Http Code 200`() = runTest {
        val emptyListStory = ListStoryResponseDTO(error = true,
            message = "list story is empty",
            listStory = listOf())
        val expectedResponse =
            MockResponse().setResponseCode(200).setBody(Gson().toJson(emptyListStory))

        mockWebServer.enqueue(expectedResponse)

        val actualResponse = listStoryRepository.getListStory("").last().data

        assertEquals(emptyListStory.listStory, actualResponse?.listStory)
    }

    @Test
    fun `when getListStory Should Http Exception Http Code 500`() = runTest {
        val expectedResponse = MockResponse().setResponseCode(500)
            .setBody(Gson().toJson(dummyListStory))

        mockWebServer.enqueue(expectedResponse)

        val actualResponse = listStoryRepository.getListStory("").last().message

        assertNotNull(actualResponse)
    }

    @Test
    fun `when getListStory Should IO Exception Error`() = runTest {
        val expectedResponse = MockResponse().setSocketPolicy(SocketPolicy.DISCONNECT_DURING_RESPONSE_BODY)

        mockWebServer.enqueue(expectedResponse)

        val actualResponse = listStoryRepository.getListStory("").last().message

        assertNotNull(actualResponse)
    }

    @Test
    fun `when getListStory Should Unknown Host Exception Error`() = runTest {
        val expectedResponse = MockResponse().setSocketPolicy(SocketPolicy.SHUTDOWN_SERVER_AFTER_RESPONSE)

        mockWebServer.enqueue(expectedResponse)

        val actualResponse = listStoryRepository.getListStory("").last().message

        assertNotNull(actualResponse)
    }
}