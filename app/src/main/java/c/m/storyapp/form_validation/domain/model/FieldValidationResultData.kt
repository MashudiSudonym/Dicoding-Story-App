package c.m.storyapp.form_validation.domain.model

import c.m.storyapp.common.util.UIText

data class FieldValidationResultData(
    val successful: Boolean,
    val errorMessage: UIText? = null,
)
