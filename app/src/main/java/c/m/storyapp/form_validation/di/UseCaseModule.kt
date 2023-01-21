package c.m.storyapp.form_validation.di

import c.m.storyapp.form_validation.domain.use_case.field_validation_use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideEmailFieldValidationUseCase(): EmailFieldValidationUseCase {
        return EmailFieldValidationUseCase()
    }

    @Provides
    @Singleton
    fun providePasswordFieldValidationUseCase(): PasswordFieldValidationUseCase {
        return PasswordFieldValidationUseCase()
    }

    @Provides
    @Singleton
    fun provideNameFieldValidationUseCase(): NameFieldValidationUseCase {
        return NameFieldValidationUseCase()
    }

    @Provides
    @Singleton
    fun provideDescriptionFieldValidationUseCase(): DescriptionFieldValidationUseCase {
        return DescriptionFieldValidationUseCase()
    }

    @Provides
    @Singleton
    fun providePhotoFieldValidationUseCase(): PhotoFieldValidationUseCase {
        return PhotoFieldValidationUseCase()
    }

}