package c.m.storyapp.authentication_check.domain.use_case.check_authentication_status_use_case

import c.m.storyapp.authentication_check.domain.model.AuthenticationStatus
import c.m.storyapp.authentication_check.domain.repository.AuthenticationCheckRepository
import c.m.storyapp.common.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CheckAuthenticationStatusUseCase @Inject constructor(private val authenticationCheckRepository: AuthenticationCheckRepository) {
    suspend operator fun invoke(): Flow<Resource<AuthenticationStatus>> {
        return authenticationCheckRepository.checkAuthentication()
    }
}