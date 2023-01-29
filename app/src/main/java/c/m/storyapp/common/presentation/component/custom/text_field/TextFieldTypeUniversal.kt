package c.m.storyapp.common.presentation.component.custom.text_field

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import c.m.storyapp.common.presentation.component.util.AdaptiveThemeColor
import c.m.storyapp.common.presentation.ui.theme.Gray30
import c.m.storyapp.common.presentation.ui.theme.Gray80
import c.m.storyapp.common.presentation.ui.theme.RedWarning
import c.m.storyapp.common.presentation.ui.theme.StoryAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldTypeUniversal(
    modifier: Modifier,
    textValue: String? = null,
    textValueChange: (String) -> Unit = {},
    placeholderText: String,
    singleLine: Boolean = true,
    isError: Boolean = false,
    errorMessage: String? = null,
    imeAction: ImeAction = ImeAction.Default,
    keyboardType: KeyboardType = KeyboardType.Text,
    keyboardActions: KeyboardActions = KeyboardActions(),
    readOnly: Boolean = false,
    enabled: Boolean = true,
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        textColor = AdaptiveThemeColor(
            isDarkTheme = isSystemInDarkTheme(),
            onDark = Color.White,
            onLight = Gray80,
        ),
        placeholderColor = Gray30,
        focusedBorderColor = Gray30,
        unfocusedBorderColor = Gray30,
        errorBorderColor = RedWarning,
        errorSupportingTextColor = RedWarning,
    ),
) {
    OutlinedTextField(
        value = textValue ?: "",
        onValueChange = textValueChange,
        placeholder = { Text(text = placeholderText) },
        enabled = enabled,
        singleLine = singleLine,
        modifier = modifier,
        keyboardOptions = KeyboardOptions(
            imeAction = imeAction,
            keyboardType = keyboardType,
        ),
        keyboardActions = keyboardActions,
        readOnly = readOnly,
        isError = isError,
        supportingText = {
            if (isError) {
                Text(
                    text = errorMessage ?: "",
                    style = MaterialTheme.typography.labelSmall
                )
            }
        },
        shape = ShapeDefaults.ExtraLarge,
        colors = colors,
    )
}

@Preview(
    showBackground = true, name = "enable text field",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun TextFieldTypeUniversalPreview() {
    StoryAppTheme {
        Surface {
            TextFieldTypeUniversal(
                modifier = Modifier,
                placeholderText = "Outline Text Placeholder",
            )
        }
    }
}

@Preview(
    showBackground = true, name = "dark mode enable text field",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun TextFieldTypeUniversalDarkModePreview() {
    TextFieldTypeUniversalPreview()
}

@Preview(
    showBackground = true, name = "enable text field error",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun TextFieldTypeUniversalErrorPreview() {
    StoryAppTheme {
        Surface {
            TextFieldTypeUniversal(
                modifier = Modifier,
                textValue = "Text content",
                placeholderText = "Outline Text Placeholder",
                isError = true,
                errorMessage = "Error Message!",
            )
        }
    }
}

@Preview(
    showBackground = true, name = "dark mode enable text field error",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun TextFieldTypeUniversalErrorDarkModePreview() {
    TextFieldTypeUniversalErrorPreview()
}