package c.m.storyapp.location_story.di

import c.m.storyapp.location_story.data.remote.LocationStoryAPI
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
    fun provideLocationStoryAPI(retrofit: Retrofit): LocationStoryAPI {
        return retrofit.create(LocationStoryAPI::class.java)
    }
}