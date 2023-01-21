package c.m.storyapp.form_validation.domain.use_case.field_validation_use_case

import c.m.storyapp.form_validation.domain.model.FieldValidationResultData

interface PasswordFieldValidationUseCase {
    operator fun invoke(password: String): FieldValidationResultData
}