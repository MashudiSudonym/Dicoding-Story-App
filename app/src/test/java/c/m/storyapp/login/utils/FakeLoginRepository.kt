package c.m.storyapp.login.utils

import c.m.storyapp.common.util.Resource
import c.m.storyapp.common.util.UIText
import c.m.storyapp.login.data.mapper.toLoginResponse
import c.m.storyapp.login.domain.model.LoginResponse
import c.m.storyapp.login.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeLoginRepository : LoginRepository {
    private val fakeLoginResponseDTO = LoginDataDummy.generateLoginResponseFakeDataDTO()

    override suspend fun postLogin(email: String, password: String): Flow<Resource<LoginResponse>> {
        return flow {
            emit(Resource.Loading(true))

            if (email.contentEquals("email.e@email.com") && password.contentEquals("123tes")) {
                emit(Resource.Loading(false))
                emit(Resource.Success(fakeLoginResponseDTO.toLoginResponse()))
            } else {
                emit(Resource.Loading(false))
                emit(Resource.Error(UIText.unknownError()))
            }
        }
    }
}