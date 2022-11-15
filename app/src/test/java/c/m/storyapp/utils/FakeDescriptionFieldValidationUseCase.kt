package c.m.storyapp.utils

import c.m.storyapp.common.domain.model.FieldValidationResultData
import c.m.storyapp.common.domain.use_case.field_validation_use_case.DescriptionFieldValidationUseCase

class FakeDescriptionFieldValidationUseCase : DescriptionFieldValidationUseCase {
    private val fakeValidationResult =
        FieldValidationResultDataDummy.generateSuccessValidationResultFakeData()

    override fun execute(description: String): FieldValidationResultData {
        return fakeValidationResult
    }
}