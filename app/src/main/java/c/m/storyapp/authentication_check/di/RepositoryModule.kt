package c.m.storyapp.authentication_check.di

import c.m.storyapp.authentication_check.data.repository.AuthenticationCheckRepositoryImpl
import c.m.storyapp.authentication_check.domain.repository.AuthenticationCheckRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAuthenticationCheckRepository(authenticationCheckRepositoryImpl: AuthenticationCheckRepositoryImpl): AuthenticationCheckRepository
}