package c.m.storyapp.register.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import c.m.storyapp.MainDispatcherRule
import c.m.storyapp.register.data.remote.RegisterAPI
import c.m.storyapp.register.data.remote.dto.RegisterResponseDTO
import c.m.storyapp.register.domain.repository.RegisterRepository
import c.m.storyapp.register.utils.RegisterDataDummy
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.SocketPolicy
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@ExperimentalCoroutinesApi
class RegisterRepositoryImplTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var registerRepository: RegisterRepository
    private lateinit var mockWebServer: MockWebServer
    private lateinit var client: OkHttpClient
    private lateinit var apiService: RegisterAPI
    private lateinit var dummyRegisterResponseDTO: RegisterResponseDTO

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
            .create(RegisterAPI::class.java)

        registerRepository = RegisterRepositoryImpl(apiService)

        dummyRegisterResponseDTO = RegisterDataDummy.generateRegisterResponseFakeDataDTO()
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `when postRegister should not be null and get http code 200`() = runTest {
        val expectedResponse =
            MockResponse().setResponseCode(200).setBody(Gson().toJson(dummyRegisterResponseDTO))

        mockWebServer.enqueue(expectedResponse)

        val actualResponse = registerRepository.postRegister("name", "email", "pass").last().data

        assertNotNull(actualResponse)
    }

    @Test
    fun `when postRegister should have error true and get http code 200`() = runTest {
        val dummyErrorRegisterResponseDTO =
            RegisterDataDummy.generateRegisterErrorResponseFakeDataDTO()
        val expectedResponse = MockResponse().setResponseCode(200)
            .setBody(Gson().toJson(dummyErrorRegisterResponseDTO))

        mockWebServer.enqueue(expectedResponse)

        val actualResponseData =
            registerRepository.postRegister("name", "email", "pass").last().data
        val actualResponseMessage =
            registerRepository.postRegister("name", "email", "pass").last().message

        assertEquals(dummyErrorRegisterResponseDTO.error, actualResponseData?.error)
        assertNotNull(actualResponseMessage)
    }

    @Test
    fun `when postRegister get http code 401`() = runTest {
        val expectedResponse =
            MockResponse().setResponseCode(401).setBody(Gson().toJson(dummyRegisterResponseDTO))

        mockWebServer.enqueue(expectedResponse)

        val actualResponse = registerRepository.postRegister("name", "email", "pass").last().message

        assertNotNull(actualResponse)
    }

    @Test
    fun `when postRegister get http code 500`() = runTest {
        val expectedResponse =
            MockResponse().setResponseCode(500).setBody(Gson().toJson(dummyRegisterResponseDTO))

        mockWebServer.enqueue(expectedResponse)

        val actualResponse = registerRepository.postRegister("name", "email", "pass").last().message

        assertNotNull(actualResponse)
    }

    @Test
    fun `when getListStory Should IO Exception Error`() = runTest {
        val expectedResponse =
            MockResponse().setSocketPolicy(SocketPolicy.DISCONNECT_DURING_RESPONSE_BODY)

        mockWebServer.enqueue(expectedResponse)

        val actualResponse = registerRepository.postRegister("name", "email", "pass").last().message

        assertNotNull(actualResponse)
    }
}