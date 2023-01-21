package c.m.storyapp.utils

import c.m.storyapp.form_validation.domain.model.FieldValidationResultData
import c.m.storyapp.form_validation.domain.use_case.field_validation_use_case.PasswordFieldValidationUseCase

class FakePasswordFieldValidationUseCase : PasswordFieldValidationUseCase {
    private val fakeValidationResult =
        FieldValidationResultDataDummy.generateSuccessValidationResultFakeData()

    override operator fun invoke(password: String): FieldValidationResultData {
        return fakeValidationResult
    }
}