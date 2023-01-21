package c.m.storyapp.register.presentation.view_model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import c.m.storyapp.MainDispatcherRule
import c.m.storyapp.form_validation.domain.use_case.field_validation_use_case.EmailFieldValidationUseCase
import c.m.storyapp.form_validation.domain.use_case.field_validation_use_case.NameFieldValidationUseCase
import c.m.storyapp.form_validation.domain.use_case.field_validation_use_case.PasswordFieldValidationUseCase
import c.m.storyapp.register.domain.use_case.user_register_use_case.UserRegisterUseCase
import c.m.storyapp.register.utils.FakeRegisterRepository
import c.m.storyapp.register.utils.RegisterUIStateDataDummy
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class RegisterViewModelTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var fakeRegisterRepository: FakeRegisterRepository
    private lateinit var userRegisterUseCase: UserRegisterUseCase
    private lateinit var nameFieldValidationUseCase: NameFieldValidationUseCase
    private lateinit var emailFieldValidationUseCase: EmailFieldValidationUseCase
    private lateinit var passwordFieldValidationUseCase: PasswordFieldValidationUseCase
    private lateinit var registerViewModel: RegisterViewModel

    @Before
    fun setUp() {
        fakeRegisterRepository = FakeRegisterRepository()
        userRegisterUseCase = UserRegisterUseCase(fakeRegisterRepository)
        nameFieldValidationUseCase = NameFieldValidationUseCase()
        emailFieldValidationUseCase = EmailFieldValidationUseCase()
        passwordFieldValidationUseCase = PasswordFieldValidationUseCase()

        registerViewModel = RegisterViewModel(
            userRegisterUseCase,
            nameFieldValidationUseCase,
            emailFieldValidationUseCase,
            passwordFieldValidationUseCase
        )
    }

    @Test
    fun `submit register data success`() = runTest {
        registerViewModel.submitRegisterData("joe", "email.e@email.com", "123tes")

        val expectedResult =
            RegisterUIStateDataDummy.generateRegisterUIStateDataDummySuccessState().isSuccess
        val currentResult = registerViewModel.registerUIState.value.isSuccess

        assertEquals(expectedResult, currentResult)
    }
}