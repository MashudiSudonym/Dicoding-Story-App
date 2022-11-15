package c.m.storyapp.common.domain.use_case.field_validation_use_case

import c.m.storyapp.common.domain.model.FieldValidationResultData

interface EmailFieldValidationUseCase {
    fun execute(email: String): FieldValidationResultData
}