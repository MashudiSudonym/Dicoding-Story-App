package c.m.storyapp.utils

import c.m.storyapp.form_validation.domain.model.FieldValidationResultData
import c.m.storyapp.form_validation.domain.use_case.field_validation_use_case.DescriptionFieldValidationUseCase

class FakeDescriptionFieldValidationUseCase : DescriptionFieldValidationUseCase {
    private val fakeValidationResult =
        FieldValidationResultDataDummy.generateSuccessValidationResultFakeData()

    override operator fun invoke(description: String): FieldValidationResultData {
        return fakeValidationResult
    }
}