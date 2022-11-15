package c.m.storyapp.common.domain.use_case.field_validation_use_case

import c.m.storyapp.common.domain.model.FieldValidationResultData
import java.io.File

interface PhotoFieldValidationUseCase {
    fun execute(photo: File): FieldValidationResultData
}