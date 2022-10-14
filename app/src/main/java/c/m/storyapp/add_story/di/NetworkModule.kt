package c.m.storyapp.add_story.di

import c.m.storyapp.add_story.data.remote.AddStoryAPI
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
    fun provideAddStoryAPI(retrofit: Retrofit): AddStoryAPI {
        return retrofit.create(AddStoryAPI::class.java)
    }
}