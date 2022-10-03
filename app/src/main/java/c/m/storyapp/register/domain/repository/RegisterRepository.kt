package c.m.storyapp.register.domain.repository

import c.m.storyapp.common.util.Resource
import c.m.storyapp.register.domain.model.RegisterResponse
import kotlinx.coroutines.flow.Flow

interface RegisterRepository {
    suspend fun postRegister(name: String, email: String, password: String): Flow<Resource<RegisterResponse>>
}