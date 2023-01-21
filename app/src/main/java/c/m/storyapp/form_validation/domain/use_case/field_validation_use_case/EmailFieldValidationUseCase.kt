package c.m.storyapp.form_validation.domain.use_case.field_validation_use_case

import c.m.storyapp.R
import c.m.storyapp.common.util.UIText
import c.m.storyapp.form_validation.domain.model.FieldValidationResultData
import java.util.regex.Pattern

class EmailFieldValidationUseCase {
    operator fun invoke(email: String): FieldValidationResultData {
        val emailPattern = Pattern.compile(
            "[a-zA-Z\\d+._%\\-]{1,256}@[a-zA-Z\\d][a-zA-Z\\d\\-]{0,64}(\\.[a-zA-Z\\d][a-zA-Z\\d\\-]{0,25})+"
        )

        if (email.isBlank()) {
            return FieldValidationResultData(
                successful = false,
                errorMessage = UIText.StringResource(R.string.error_validation_email_is_blank)
            )
        }

        if (!emailPattern.matcher(email).matches()) {
            return FieldValidationResultData(
                successful = false,
                errorMessage = UIText.StringResource(R.string.error_validation_email_format_email_wrong)
            )
        }

        return FieldValidationResultData(successful = true)
    }
}