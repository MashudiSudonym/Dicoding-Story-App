package c.m.storyapp.add_story.di

import c.m.storyapp.add_story.data.repository.AddStoryRepositoryImpl
import c.m.storyapp.add_story.domain.repository.AddStoryRepository
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
    abstract fun bindAddStoryRepository(addStoryRepositoryImpl: AddStoryRepositoryImpl): AddStoryRepository
}