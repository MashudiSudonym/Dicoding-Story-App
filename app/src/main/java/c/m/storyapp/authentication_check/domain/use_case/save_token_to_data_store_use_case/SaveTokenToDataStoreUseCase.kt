package c.m.storyapp.authentication_check.domain.use_case.save_token_to_data_store_use_case

import c.m.storyapp.authentication_check.domain.repository.AuthenticationCheckRepository
import c.m.storyapp.common.util.SimpleResource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SaveTokenToDataStoreUseCase @Inject constructor(private val authenticationCheckRepository: AuthenticationCheckRepository) {
    suspend operator fun invoke(token: String): Flow<SimpleResource> {
        return authenticationCheckRepository.saveToken(token)
    }
}