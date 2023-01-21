package c.m.storyapp.form_validation.di

import c.m.storyapp.form_validation.domain.use_case.field_validation_use_case.*
import c.m.storyapp.form_validation.domain.use_case.field_validation_use_case_impl.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {
    @Binds
    @Singleton
    abstract fun bindEmailFieldValidationUseCase(emailFieldValidationUseCaseImpl: EmailFieldValidationUseCaseImpl): EmailFieldValidationUseCase

    @Binds
    @Singleton
    abstract fun bindPasswordFieldValidationUseCase(passwordFieldValidationUseCaseImpl: PasswordFieldValidationUseCaseImpl): PasswordFieldValidationUseCase

    @Binds
    @Singleton
    abstract fun bindNameFieldValidationUseCase(nameFieldValidationUseCaseImpl: NameFieldValidationUseCaseImpl): NameFieldValidationUseCase

    @Binds
    @Singleton
    abstract fun bindDescriptionFieldValidationUseCase(descriptionFieldValidationUseCaseImpl: DescriptionFieldValidationUseCaseImpl): DescriptionFieldValidationUseCase

    @Binds
    @Singleton
    abstract fun bindPhotoFieldValidationUseCase(photoFieldValidationUseCaseImpl: PhotoFieldValidationUseCaseImpl): PhotoFieldValidationUseCase

}