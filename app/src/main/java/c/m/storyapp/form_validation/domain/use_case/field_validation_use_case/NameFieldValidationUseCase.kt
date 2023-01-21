package c.m.storyapp.form_validation.domain.use_case.field_validation_use_case

import c.m.storyapp.R
import c.m.storyapp.common.util.UIText
import c.m.storyapp.form_validation.domain.model.FieldValidationResultData

class NameFieldValidationUseCase {
    operator fun invoke(name: String): FieldValidationResultData {
        if (name.isBlank()) {
            return FieldValidationResultData(
                successful = false,
                errorMessage = UIText.StringResource(R.string.error_validation_name_is_blank)
            )
        }

        return FieldValidationResultData(successful = true)
    }
}