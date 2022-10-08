package c.m.storyapp.list_story.di

import c.m.storyapp.list_story.data.remote.ListStoryAPI
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
    fun provideListStoryAPI(retrofit: Retrofit): ListStoryAPI {
        return retrofit.create(ListStoryAPI::class.java)
    }
}