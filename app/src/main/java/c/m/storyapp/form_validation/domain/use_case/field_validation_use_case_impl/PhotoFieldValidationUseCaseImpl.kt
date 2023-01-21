package c.m.storyapp.form_validation.domain.use_case.field_validation_use_case_impl

import c.m.storyapp.R
import c.m.storyapp.common.util.UIText
import c.m.storyapp.form_validation.domain.model.FieldValidationResultData
import c.m.storyapp.form_validation.domain.use_case.field_validation_use_case.PhotoFieldValidationUseCase
import java.io.File
import javax.inject.Inject

class PhotoFieldValidationUseCaseImpl @Inject constructor() : PhotoFieldValidationUseCase {
    override operator fun invoke(photo: File): FieldValidationResultData {
        if (photo == null) {
            return FieldValidationResultData(
                successful = false,
                errorMessage = UIText.StringResource(R.string.error_validation_photo_is_blank)
            )
        }

        return FieldValidationResultData(successful = true)
    }
}