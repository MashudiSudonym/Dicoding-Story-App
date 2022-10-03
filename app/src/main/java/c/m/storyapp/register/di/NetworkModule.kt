package c.m.storyapp.register.di

import c.m.storyapp.register.data.remote.RegisterAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRegisterAPI(retrofit: Retrofit): RegisterAPI {
        return retrofit.create(RegisterAPI::class.java)
    }
}