package c.m.storyapp.utils

import c.m.storyapp.form_validation.domain.model.FieldValidationResultData
import c.m.storyapp.form_validation.domain.use_case.field_validation_use_case.PhotoFieldValidationUseCase
import java.io.File

class FakePhotoFieldValidationUseCase : PhotoFieldValidationUseCase {
    private val fakeValidationResult =
        FieldValidationResultDataDummy.generateSuccessValidationResultFakeData()

    override operator fun invoke(photo: File): FieldValidationResultData {
        return fakeValidationResult
    }
}