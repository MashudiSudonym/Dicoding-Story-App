package c.m.storyapp.common.domain.use_case.field_validation_use_case

import c.m.storyapp.R
import c.m.storyapp.common.domain.model.FieldValidationResultData
import c.m.storyapp.common.util.UIText
import javax.inject.Inject

class NameFieldValidationUseCase @Inject constructor() {
    fun execute(name: String): FieldValidationResultData {
        if (name.isBlank()) {
            return FieldValidationResultData(
                successful = false,
                errorMessage = UIText.StringResource(R.string.error_validation_name_is_blank)
            )
        }

        return FieldValidationResultData(successful = true)
    }
}