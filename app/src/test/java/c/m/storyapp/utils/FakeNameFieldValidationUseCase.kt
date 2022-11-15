package c.m.storyapp.utils

import c.m.storyapp.common.domain.model.FieldValidationResultData
import c.m.storyapp.common.domain.use_case.field_validation_use_case.NameFieldValidationUseCase

class FakeNameFieldValidationUseCase : NameFieldValidationUseCase {
    private val fakeValidationResult =
        FieldValidationResultDataDummy.generateSuccessValidationResultFakeData()

    override fun execute(name: String): FieldValidationResultData {
        return fakeValidationResult
    }
}