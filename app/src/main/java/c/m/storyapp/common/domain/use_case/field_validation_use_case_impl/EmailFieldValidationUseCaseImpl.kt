package c.m.storyapp.common.domain.use_case.field_validation_use_case_impl

import android.util.Patterns
import c.m.storyapp.R
import c.m.storyapp.common.domain.model.FieldValidationResultData
import c.m.storyapp.common.domain.use_case.field_validation_use_case.EmailFieldValidationUseCase
import c.m.storyapp.common.util.UIText
import javax.inject.Inject

class EmailFieldValidationUseCaseImpl @Inject constructor() : EmailFieldValidationUseCase {
    override fun execute(email: String): FieldValidationResultData {
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