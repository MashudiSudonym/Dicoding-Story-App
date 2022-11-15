package c.m.storyapp.register.presentation.view_model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import c.m.storyapp.MainDispatcherRule
import c.m.storyapp.register.domain.use_case.user_register_use_case.UserRegisterUseCase
import c.m.storyapp.register.utils.FakeRegisterRepository
import c.m.storyapp.register.utils.RegisterUIStateDataDummy
import c.m.storyapp.utils.FakeEmailFieldValidationUseCase
import c.m.storyapp.utils.FakeNameFieldValidationUseCase
import c.m.storyapp.utils.FakePasswordFieldValidationUseCase
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
    private lateinit var fakeNameFieldValidationUseCase: FakeNameFieldValidationUseCase
    private lateinit var fakeEmailFieldValidationUseCase: FakeEmailFieldValidationUseCase
    private lateinit var fakePasswordFieldValidationUseCase: FakePasswordFieldValidationUseCase
    private lateinit var registerViewModel: RegisterViewModel

    @Before
    fun setUp() {
        fakeRegisterRepository = FakeRegisterRepository()
        userRegisterUseCase = UserRegisterUseCase(fakeRegisterRepository)
        fakeNameFieldValidationUseCase = FakeNameFieldValidationUseCase()
        fakeEmailFieldValidationUseCase = FakeEmailFieldValidationUseCase()
        fakePasswordFieldValidationUseCase = FakePasswordFieldValidationUseCase()

        registerViewModel = RegisterViewModel(
            userRegisterUseCase,
            fakeNameFieldValidationUseCase,
            fakeEmailFieldValidationUseCase,
            fakePasswordFieldValidationUseCase
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