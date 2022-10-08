package c.m.storyapp.authentication_check.domain.use_case.get_token_from_data_store_use_case

import c.m.storyapp.authentication_check.domain.model.AuthenticationToken
import c.m.storyapp.authentication_check.domain.repository.AuthenticationCheckRepository
import c.m.storyapp.common.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTokenFromDataStoreUseCase @Inject constructor(private val authenticationCheckRepository: AuthenticationCheckRepository) {
    suspend operator fun invoke(): Flow<Resource<AuthenticationToken>> {
        return authenticationCheckRepository.getToken()
    }
}