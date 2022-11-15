package c.m.storyapp.utils

import c.m.storyapp.common.domain.model.FieldValidationResultData
import c.m.storyapp.common.domain.use_case.field_validation_use_case.PasswordFieldValidationUseCase

class FakePasswordFieldValidationUseCase : PasswordFieldValidationUseCase {
    private val fakeValidationResult =
        FieldValidationResultDataDummy.generateSuccessValidationResultFakeData()

    override fun execute(password: String): FieldValidationResultData {
        return fakeValidationResult
    }
}