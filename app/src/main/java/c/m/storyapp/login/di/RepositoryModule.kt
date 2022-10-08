package c.m.storyapp.login.di

import c.m.storyapp.login.data.repository.LoginRepositoryImpl
import c.m.storyapp.login.domain.repository.LoginRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class  RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindLoginRepository(loginRepositoryImpl: LoginRepositoryImpl): LoginRepository
}