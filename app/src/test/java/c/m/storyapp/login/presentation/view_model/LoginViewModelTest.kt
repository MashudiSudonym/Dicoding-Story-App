package c.m.storyapp.login.presentation.view_model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import c.m.storyapp.MainDispatcherRule
import c.m.storyapp.authentication_check.domain.use_case.save_token_to_data_store_use_case.SaveTokenToDataStoreUseCase
import c.m.storyapp.authentication_check.utils.FakeAuthenticationCheckRepository
import c.m.storyapp.login.domain.use_case.user_login_use_case.UserLoginUseCase
import c.m.storyapp.login.presentation.event.InputLoginDataEvent
import c.m.storyapp.login.utils.FakeLoginRepository
import c.m.storyapp.login.utils.LoginUIStateDataDummy
import c.m.storyapp.utils.FakeEmailFieldValidationUseCase
import c.m.storyapp.utils.FakePasswordFieldValidationUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class LoginViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var fakeLoginRepository: FakeLoginRepository
    private lateinit var fakeAuthenticationCheckRepository: FakeAuthenticationCheckRepository
    private lateinit var userLoginUseCase: UserLoginUseCase
    private lateinit var saveTokenToDataStorageUseCase: SaveTokenToDataStoreUseCase
    private lateinit var emailFieldValidationUseCase: FakeEmailFieldValidationUseCase
    private lateinit var passwordFieldValidationUseCase: FakePasswordFieldValidationUseCase
    private lateinit var loginViewModel: LoginViewModel

    @Before
    fun setUp() {
        fakeLoginRepository = FakeLoginRepository()
        fakeAuthenticationCheckRepository = FakeAuthenticationCheckRepository()
        userLoginUseCase = UserLoginUseCase(fakeLoginRepository)
        saveTokenToDataStorageUseCase =
            SaveTokenToDataStoreUseCase(fakeAuthenticationCheckRepository)
        emailFieldValidationUseCase = FakeEmailFieldValidationUseCase()
        passwordFieldValidationUseCase = FakePasswordFieldValidationUseCase()

        loginViewModel = LoginViewModel(userLoginUseCase,
            saveTokenToDataStorageUseCase,
            emailFieldValidationUseCase,
            passwordFieldValidationUseCase)
    }

    @Test
    fun `submit login data success`() = runTest {
        //loginViewModel.submitLoginData("email.e@email.com", "123tes")

        loginViewModel.onInputFieldEvent(event = InputLoginDataEvent.EmailFieldChange("email.e@email.com"))
        loginViewModel.onInputFieldEvent(event = InputLoginDataEvent.PasswordFieldChange("123tes"))
        loginViewModel.onInputFieldEvent(event = InputLoginDataEvent.CheckUserLoginData)
        loginViewModel.onInputFieldEvent(event = InputLoginDataEvent.SubmitUserLoginData)

        val expectedStatus =
            LoginUIStateDataDummy.generateLoginUIStateSuccessStateDataDummy().isSuccess
        val currentStatus = loginViewModel.loginUIState.value.isSuccess

        assertEquals(expectedStatus, currentStatus)
    }
}