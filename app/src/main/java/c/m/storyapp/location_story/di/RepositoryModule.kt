package c.m.storyapp.location_story.di

import c.m.storyapp.location_story.data.repository.LocationStoryRepositoryImpl
import c.m.storyapp.location_story.domain.repository.LocationStoryRepository
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
    abstract fun bindLocationStoryRepository(locationStoryRepositoryImpl: LocationStoryRepositoryImpl): LocationStoryRepository
}