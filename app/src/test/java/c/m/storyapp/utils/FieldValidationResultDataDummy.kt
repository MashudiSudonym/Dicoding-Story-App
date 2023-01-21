package c.m.storyapp.utils

import c.m.storyapp.form_validation.domain.model.FieldValidationResultData

object FieldValidationResultDataDummy {
    fun generateSuccessValidationResultFakeData(): FieldValidationResultData {
        return FieldValidationResultData(
            successful = true,
        )
    }
}