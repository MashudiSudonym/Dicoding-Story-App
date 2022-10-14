package c.m.storyapp.authentication_check.domain.use_case.logout_use_case

import c.m.storyapp.authentication_check.domain.repository.AuthenticationCheckRepository
import c.m.storyapp.common.util.Constants
import c.m.storyapp.common.util.SimpleResource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LogoutUseCase @Inject constructor(private val authenticationCheckRepository: AuthenticationCheckRepository) {
    suspend operator fun invoke(): Flow<SimpleResource> {
        return authenticationCheckRepository.saveToken(Constants.BLANK_STRING)
    }
}