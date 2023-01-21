package c.m.storyapp.form_validation.domain.use_case.field_validation_use_case

import c.m.storyapp.R
import c.m.storyapp.common.util.UIText
import c.m.storyapp.form_validation.domain.model.FieldValidationResultData

class PasswordFieldValidationUseCase {
    operator fun invoke(password: String): FieldValidationResultData {
        if (password.isBlank()) {
            return FieldValidationResultData(
                successful = false,
                errorMessage = UIText.StringResource(R.string.error_validation_password_is_blank)
            )
        }

        if (password.length < 6) {
            return FieldValidationResultData(
                successful = false,
                errorMessage = UIText.StringResource(R.string.error_password_less_6_char)
            )
        }


        return FieldValidationResultData(successful = true)
    }
}