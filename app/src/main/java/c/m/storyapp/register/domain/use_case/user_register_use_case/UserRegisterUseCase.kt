package c.m.storyapp.register.domain.use_case.user_register_use_case

import c.m.storyapp.common.util.Resource
import c.m.storyapp.register.domain.model.RegisterResponse
import c.m.storyapp.register.domain.repository.RegisterRepository
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class UserRegisterUseCase @Inject constructor(private val registerRepository: RegisterRepository) {
    suspend operator fun invoke(
        name: String,
        email: String,
        password: String,
    ): Flow<Resource<RegisterResponse>> {
        return registerRepository.postRegister(name, email, password)
    }
}