package c.m.storyapp.form_validation.domain.use_case.field_validation_use_case_impl

import c.m.storyapp.R
import c.m.storyapp.common.util.UIText
import c.m.storyapp.form_validation.domain.model.FieldValidationResultData
import c.m.storyapp.form_validation.domain.use_case.field_validation_use_case.DescriptionFieldValidationUseCase
import javax.inject.Inject

class DescriptionFieldValidationUseCaseImpl @Inject constructor() :
    DescriptionFieldValidationUseCase {
    override operator fun invoke(description: String): FieldValidationResultData {
        if (description.isBlank()) {
            return FieldValidationResultData(
                successful = false,
                errorMessage = UIText.StringResource(R.string.error_validation_description_is_blank)
            )
        }

        return FieldValidationResultData(successful = true)
    }
}