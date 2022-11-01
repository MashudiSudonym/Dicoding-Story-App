package c.m.storyapp.login.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import c.m.storyapp.MainDispatcherRule
import c.m.storyapp.login.data.remote.LoginAPI
import c.m.storyapp.login.data.remote.dto.LoginResponseDTO
import c.m.storyapp.login.domain.repository.LoginRepository
import c.m.storyapp.login.utils.LoginDataDummy
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
class LoginRepositoryImplTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var loginRepository: LoginRepository
    private lateinit var mockWebServer: MockWebServer
    private lateinit var client: OkHttpClient
    private lateinit var apiService: LoginAPI
    private lateinit var dummyLoginResponseDTO: LoginResponseDTO

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
            .create(LoginAPI::class.java)

        loginRepository = LoginRepositoryImpl(apiService)

        dummyLoginResponseDTO = LoginDataDummy.generateLoginResponseFakeDataDTO()
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `when postLogin should not be null and get http code 200`() = runTest {
        val expectedResponse =
            MockResponse().setResponseCode(200).setBody(Gson().toJson(dummyLoginResponseDTO))

        mockWebServer.enqueue(expectedResponse)

        val actualResponse = loginRepository.postLogin("email", "pass").last().data

        assertNotNull(actualResponse)
    }

    @Test
    fun `when postLogin should have the same user id data as user id dummy data and get http code 200`() =
        runTest {
            val expectedResponse =
                MockResponse().setResponseCode(200).setBody(Gson().toJson(dummyLoginResponseDTO))

            mockWebServer.enqueue(expectedResponse)

            val actualResponse = loginRepository.postLogin("email", "pass").last().data

            // user id check
            assertEquals(dummyLoginResponseDTO.loginResult.userId,
                actualResponse?.loginResult?.userId)
        }

    @Test
    fun `when postLogin should have the same name data as name dummy data and get http code 200`() =
        runTest {
            val expectedResponse =
                MockResponse().setResponseCode(200).setBody(Gson().toJson(dummyLoginResponseDTO))

            mockWebServer.enqueue(expectedResponse)

            val actualResponse = loginRepository.postLogin("email", "pass").last().data

            // user id check
            assertEquals(dummyLoginResponseDTO.loginResult.name, actualResponse?.loginResult?.name)
        }

    @Test
    fun `when postLogin should have error true and get http code 200`() = runTest {
        val dummyErrorLoginResponseDTO = LoginDataDummy.generateLoginErrorResponseFakeDataDTO()
        val expectedResponse =
            MockResponse().setResponseCode(200).setBody(Gson().toJson(dummyErrorLoginResponseDTO))

        mockWebServer.enqueue(expectedResponse)

        val actualResponseData = loginRepository.postLogin("email", "pass").last().data
        val actualResponseMessage = loginRepository.postLogin("email", "pass").last().message

        assertEquals(dummyErrorLoginResponseDTO.error, actualResponseData?.error)
        assertNotNull(actualResponseMessage)
    }

    @Test
    fun `when postLogin should have the same token data as token dummy data and get http code 200`() =
        runTest {
            val expectedResponse =
                MockResponse().setResponseCode(200).setBody(Gson().toJson(dummyLoginResponseDTO))

            mockWebServer.enqueue(expectedResponse)

            val actualResponse = loginRepository.postLogin("email", "pass").last().data

            // user id check
            assertEquals(dummyLoginResponseDTO.loginResult.token,
                actualResponse?.loginResult?.token)
        }

    @Test
    fun `when postLogin get http code 401`() = runTest {
        val expectedResponse =
            MockResponse().setResponseCode(401).setBody(Gson().toJson(dummyLoginResponseDTO))

        mockWebServer.enqueue(expectedResponse)

        val actualResponse = loginRepository.postLogin("email", "pass").last().message

        assertNotNull(actualResponse)
    }

    @Test
    fun `when postLogin get http code 500`() = runTest {
        val expectedResponse =
            MockResponse().setResponseCode(500).setBody(Gson().toJson(dummyLoginResponseDTO))

        mockWebServer.enqueue(expectedResponse)

        val actualResponse = loginRepository.postLogin("email", "pass").last().message

        assertNotNull(actualResponse)
    }

    @Test
    fun `when postLogin Should IO Exception Error`() = runTest {
        val expectedResponse =
            MockResponse().setSocketPolicy(SocketPolicy.DISCONNECT_DURING_RESPONSE_BODY)

        mockWebServer.enqueue(expectedResponse)

        val actualResponse = loginRepository.postLogin("email", "pass").last().message

        assertNotNull(actualResponse)
    }
}