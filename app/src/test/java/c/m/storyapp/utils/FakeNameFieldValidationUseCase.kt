package c.m.storyapp.utils

import c.m.storyapp.form_validation.domain.model.FieldValidationResultData
import c.m.storyapp.form_validation.domain.use_case.field_validation_use_case.NameFieldValidationUseCase

class FakeNameFieldValidationUseCase : NameFieldValidationUseCase {
    private val fakeValidationResult =
        FieldValidationResultDataDummy.generateSuccessValidationResultFakeData()

    override operator fun invoke(name: String): FieldValidationResultData {
        return fakeValidationResult
    }
}