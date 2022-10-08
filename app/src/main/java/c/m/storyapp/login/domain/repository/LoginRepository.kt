package c.m.storyapp.login.domain.repository

import c.m.storyapp.common.util.Resource
import c.m.storyapp.login.domain.model.LoginResponse
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun postLogin(email: String, password: String): Flow<Resource<LoginResponse>>
}