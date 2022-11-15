package c.m.storyapp.utils

import c.m.storyapp.common.domain.model.FieldValidationResultData

object FieldValidationResultDataDummy {
    fun generateSuccessValidationResultFakeData(): FieldValidationResultData {
        return FieldValidationResultData(
            successful = true,
        )
    }
}