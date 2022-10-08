package c.m.storyapp.authentication_check.domain.repository

import c.m.storyapp.authentication_check.domain.model.AuthenticationStatus
import c.m.storyapp.authentication_check.domain.model.AuthenticationToken
import c.m.storyapp.common.util.Resource
import c.m.storyapp.common.util.SimpleResource
import kotlinx.coroutines.flow.Flow

interface AuthenticationCheckRepository {
    suspend fun saveToken(token: String): Flow<SimpleResource>
    suspend fun checkAuthentication(): Flow<Resource<AuthenticationStatus>>
    suspend fun getToken(): Flow<Resource<AuthenticationToken>>
}