package c.m.storyapp.register.utils

import c.m.storyapp.common.util.Resource
import c.m.storyapp.register.data.mapper.toRegisterResponse
import c.m.storyapp.register.domain.model.RegisterResponse
import c.m.storyapp.register.domain.repository.RegisterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeRegisterRepository : RegisterRepository {
    private val fakeRegisterResponseDTO = RegisterDataDummy.generateRegisterResponseFakeDataDTO()

    override suspend fun postRegister(
        name: String,
        email: String,
        password: String,
    ): Flow<Resource<RegisterResponse>> {
        return flow {
            emit(Resource.Loading(true))
            emit(Resource.Loading(false))
            emit(Resource.Success(fakeRegisterResponseDTO.toRegisterResponse()))
        }
    }
}