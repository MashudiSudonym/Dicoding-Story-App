package c.m.storyapp.common.domain.use_case.field_validation_use_case_impl

import c.m.storyapp.R
import c.m.storyapp.common.domain.model.FieldValidationResultData
import c.m.storyapp.common.domain.use_case.field_validation_use_case.DescriptionFieldValidationUseCase
import c.m.storyapp.common.util.UIText
import javax.inject.Inject

class DescriptionFieldValidationUseCaseImpl @Inject constructor() :
    DescriptionFieldValidationUseCase {
    override fun execute(description: String): FieldValidationResultData {
        if (description.isBlank()) {
            return FieldValidationResultData(
                successful = false,
                errorMessage = UIText.StringResource(R.string.error_validation_description_is_blank)
            )
        }

        return FieldValidationResultData(successful = true)
    }
}