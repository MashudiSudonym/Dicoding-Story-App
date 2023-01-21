package c.m.storyapp.form_validation.domain.use_case.field_validation_use_case_impl

import android.util.Patterns
import c.m.storyapp.R
import c.m.storyapp.common.util.UIText
import c.m.storyapp.form_validation.domain.model.FieldValidationResultData
import c.m.storyapp.form_validation.domain.use_case.field_validation_use_case.EmailFieldValidationUseCase
import javax.inject.Inject

class EmailFieldValidationUseCaseImpl @Inject constructor() : EmailFieldValidationUseCase {
    override operator fun invoke(email: String): FieldValidationResultData {
        if (email.isBlank()) {
            return FieldValidationResultData(
                successful = false,
                errorMessage = UIText.StringResource(R.string.error_validation_email_is_blank)
            )
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return FieldValidationResultData(
                successful = false,
                errorMessage = UIText.StringResource(R.string.error_validation_email_format_email_wrong)
            )
        }

        return FieldValidationResultData(successful = true)
    }
}