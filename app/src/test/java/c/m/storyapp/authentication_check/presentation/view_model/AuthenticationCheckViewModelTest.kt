package c.m.storyapp.authentication_check.presentation.view_model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import c.m.storyapp.MainDispatcherRule
import c.m.storyapp.authentication_check.domain.use_case.check_authentication_status_use_case.CheckAuthenticationStatusUseCase
import c.m.storyapp.authentication_check.utils.AuthenticationCheckUIStateDataDummy
import c.m.storyapp.authentication_check.utils.FakeAuthenticationCheckRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class AuthenticationCheckViewModelTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var fakeAuthenticationCheckRepository: FakeAuthenticationCheckRepository
    private lateinit var checkAuthenticationStatusUseCase: CheckAuthenticationStatusUseCase
    private lateinit var authenticationCheckViewModel: AuthenticationCheckViewModel

    @Before
    fun setUp() {
        fakeAuthenticationCheckRepository = FakeAuthenticationCheckRepository()
        checkAuthenticationStatusUseCase =
            CheckAuthenticationStatusUseCase(fakeAuthenticationCheckRepository)
        authenticationCheckViewModel =
            AuthenticationCheckViewModel(checkAuthenticationStatusUseCase)
    }

    @Test
    fun `is authentication success`() = runTest {
        authenticationCheckViewModel

        val expectedResult =
            AuthenticationCheckUIStateDataDummy.generateAuthenticationCheckUIStateSuccessStateFakeData().isAuthenticated
        val currentResult =
            authenticationCheckViewModel.authenticationCheckUIState.value.isAuthenticated

        assertEquals(expectedResult, currentResult)
    }
}