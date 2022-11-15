package c.m.storyapp.authentication_check.utils

import c.m.storyapp.authentication_check.domain.model.AuthenticationStatus
import c.m.storyapp.authentication_check.domain.model.AuthenticationToken
import c.m.storyapp.authentication_check.domain.repository.AuthenticationCheckRepository
import c.m.storyapp.common.util.Resource
import c.m.storyapp.common.util.SimpleResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeAuthenticationCheckRepository : AuthenticationCheckRepository {
    private val fakeAuthenticationStatus =
        AuthenticationStatusDataDummy.generateAuthenticationStatusSuccessFakeData()
    private val fakeAuthenticationToken =
        AuthenticationTokenDataDummy.generateAuthenticationTokenFakeData()

    override suspend fun saveToken(token: String): Flow<SimpleResource> {
        return flow {
            emit(Resource.Loading(true))
            emit(Resource.Loading(false))
            emit(Resource.Success(Unit))
        }
    }

    override suspend fun checkAuthentication(): Flow<Resource<AuthenticationStatus>> {
        return flow {
            emit(Resource.Loading(true))
            emit(Resource.Loading(false))
            emit(Resource.Success(fakeAuthenticationStatus))
        }
    }

    override suspend fun getToken(): Flow<Resource<AuthenticationToken>> {
        return flow {
            emit(Resource.Loading(true))
            emit(Resource.Loading(false))
            emit(Resource.Success(fakeAuthenticationToken))
        }
    }
}