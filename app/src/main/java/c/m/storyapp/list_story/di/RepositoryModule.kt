package c.m.storyapp.list_story.di

import c.m.storyapp.list_story.data.repository.ListStoryRepositoryImpl
import c.m.storyapp.list_story.domain.repository.ListStoryRepository
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
    abstract fun bindListStoryRepository(listStoryRepositoryImpl: ListStoryRepositoryImpl): ListStoryRepository
}