package c.m.storyapp.login.presentation.view_model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import c.m.storyapp.MainDispatcherRule
import c.m.storyapp.authentication_check.domain.use_case.save_token_to_data_store_use_case.SaveTokenToDataStoreUseCase
import c.m.storyapp.authentication_check.utils.FakeAuthenticationCheckRepository
import c.m.storyapp.form_validation.domain.use_case.field_validation_use_case.EmailFieldValidationUseCase
import c.m.storyapp.form_validation.domain.use_case.field_validation_use_case.PasswordFieldValidationUseCase
import c.m.storyapp.login.domain.use_case.user_login_use_case.UserLoginUseCase
import c.m.storyapp.login.presentation.event.InputLoginDataEvent
import c.m.storyapp.login.utils.FakeLoginRepository
import c.m.storyapp.login.utils.LoginUIStateDataDummy
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
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
    private lateinit var emailFieldValidationUseCase: EmailFieldValidationUseCase
    private lateinit var passwordFieldValidationUseCase: PasswordFieldValidationUseCase
    private lateinit var loginViewModel: LoginViewModel

    @Before
    fun setUp() {
        fakeLoginRepository = FakeLoginRepository()
        fakeAuthenticationCheckRepository = FakeAuthenticationCheckRepository()
        userLoginUseCase = UserLoginUseCase(fakeLoginRepository)
        saveTokenToDataStorageUseCase =
            SaveTokenToDataStoreUseCase(fakeAuthenticationCheckRepository)
        emailFieldValidationUseCase = EmailFieldValidationUseCase()
        passwordFieldValidationUseCase = PasswordFieldValidationUseCase()

        loginViewModel = LoginViewModel(
            userLoginUseCase,
            saveTokenToDataStorageUseCase,
            emailFieldValidationUseCase,
            passwordFieldValidationUseCase,
        )
    }

    /**
     * The function name should describe the test scenario used.
     */
    @Test
    fun `user login failed email is blank scenario`() = runTest {
        loginViewModel.onInputFieldEvent(event = InputLoginDataEvent.EmailFieldChange(""))
        loginViewModel.onInputFieldEvent(event = InputLoginDataEvent.PasswordFieldChange("123tes"))
        loginViewModel.onInputFieldEvent(event = InputLoginDataEvent.CheckUserLoginData)
        loginViewModel.onInputFieldEvent(event = InputLoginDataEvent.SubmitUserLoginData)

        val expectedStatus =
            LoginUIStateDataDummy.generateLoginUIStateFailedFieldValidationLoginStateDataDummy()
        val currentStatus = loginViewModel.loginUIState.value

        assertEquals(expectedStatus.isError, currentStatus.isError)
        assertNotNull(currentStatus.emailFieldError)
    }

    @Test
    fun `user login failed password is blank scenario`() = runTest {
        loginViewModel.onInputFieldEvent(event = InputLoginDataEvent.EmailFieldChange("email.e@email.com"))
        loginViewModel.onInputFieldEvent(event = InputLoginDataEvent.PasswordFieldChange(""))
        loginViewModel.onInputFieldEvent(event = InputLoginDataEvent.CheckUserLoginData)
        loginViewModel.onInputFieldEvent(event = InputLoginDataEvent.SubmitUserLoginData)

        val expectedStatus =
            LoginUIStateDataDummy.generateLoginUIStateFailedFieldValidationLoginStateDataDummy()
        val currentStatus = loginViewModel.loginUIState.value

        assertEquals(expectedStatus.isError, currentStatus.isError)
        assertNotNull(currentStatus.passwordFieldError)
    }

    @Test
    fun `user login success scenario`() = runTest {
        loginViewModel.onInputFieldEvent(event = InputLoginDataEvent.EmailFieldChange("email.e@email.com"))
        loginViewModel.onInputFieldEvent(event = InputLoginDataEvent.PasswordFieldChange("123tes"))
        loginViewModel.onInputFieldEvent(event = InputLoginDataEvent.CheckUserLoginData)
        loginViewModel.onInputFieldEvent(event = InputLoginDataEvent.SubmitUserLoginData)

        val expectedStatus =
            LoginUIStateDataDummy.generateLoginUIStateSuccessLoginStateDataDummy().isSuccess
        val currentStatus = loginViewModel.loginUIState.value.isSuccess

        assertEquals(expectedStatus, currentStatus)
    }

    @Test
    fun `user login failed wrong email and password scenario`() = runTest {
        loginViewModel.onInputFieldEvent(event = InputLoginDataEvent.EmailFieldChange("email.1@email.com"))
        loginViewModel.onInputFieldEvent(event = InputLoginDataEvent.PasswordFieldChange("1234tes"))
        loginViewModel.onInputFieldEvent(event = InputLoginDataEvent.CheckUserLoginData)
        loginViewModel.onInputFieldEvent(event = InputLoginDataEvent.SubmitUserLoginData)

        val expectedStatus =
            LoginUIStateDataDummy.generateLoginUIStateFailedLoginStateDataDummy()
        val currentStatus = loginViewModel.loginUIState.value

        assertEquals(expectedStatus.isError, currentStatus.isError)
        assertNotNull(currentStatus.errorMessage)
    }
}