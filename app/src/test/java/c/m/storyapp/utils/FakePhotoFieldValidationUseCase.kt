package c.m.storyapp.utils

import c.m.storyapp.common.domain.model.FieldValidationResultData
import c.m.storyapp.common.domain.use_case.field_validation_use_case.PhotoFieldValidationUseCase
import java.io.File

class FakePhotoFieldValidationUseCase : PhotoFieldValidationUseCase {
    private val fakeValidationResult =
        FieldValidationResultDataDummy.generateSuccessValidationResultFakeData()

    override fun execute(photo: File): FieldValidationResultData {
        return fakeValidationResult
    }
}