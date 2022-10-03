package c.m.storyapp.login.domain.use_case.login_use_case

import c.m.storyapp.common.util.Resource
import c.m.storyapp.login.domain.model.LoginResponse
import c.m.storyapp.login.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val loginRepository: LoginRepository) {
    suspend operator fun invoke(email: String, password: String): Flow<Resource<LoginResponse>> {
        return loginRepository.postLogin(email, password)
    }
}