package c.m.storyapp.common.presentation.component.custom.text_field

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import c.m.storyapp.common.presentation.component.util.AdaptiveThemeColor
import c.m.storyapp.common.presentation.ui.theme.Gray30
import c.m.storyapp.common.presentation.ui.theme.Gray80
import c.m.storyapp.common.presentation.ui.theme.RedWarning
import c.m.storyapp.common.presentation.ui.theme.StoryAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldTypePassword(
    modifier: Modifier,
    textValue: String? = null,
    textValueChange: (String) -> Unit = {},
    placeholderText: String,
    isError: Boolean = false,
    errorMessage: String? = null,
    imeAction: ImeAction = ImeAction.Default,
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
    val showPassword = remember { mutableStateOf(false) }

    OutlinedTextField(
        value = textValue ?: "",
        onValueChange = textValueChange,
        placeholder = { Text(text = placeholderText) },
        enabled = enabled,
        singleLine = true,
        modifier = modifier,
        keyboardOptions = KeyboardOptions(
            imeAction = imeAction,
            keyboardType = KeyboardType.Password,
        ),
        keyboardActions = keyboardActions,
        readOnly = readOnly,
        isError = isError,
        trailingIcon = {
            val (icon, iconColor) = if (showPassword.value) {
                Pair(
                    Icons.Filled.VisibilityOff,
                    Gray30,
                )
            } else {
                Pair(Icons.Filled.Visibility, Gray30)
            }

            IconButton(onClick = { showPassword.value = !showPassword.value }) {
                Icon(
                    icon,
                    contentDescription = "Password Visible",
                    tint = iconColor
                )
            }
        },
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
        visualTransformation = if (showPassword.value) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
    )
}

@Preview(
    showBackground = true, name = "enable text field",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun TextFieldTypePasswordPreview() {
    StoryAppTheme {
        Surface {
            TextFieldTypePassword(modifier = Modifier, placeholderText = "Outline Text Placeholder")
        }
    }
}

@Preview(
    showBackground = true, name = "dark mode enable text field password",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun TextFieldTypePasswordDarkModePreview() {
    TextFieldTypePasswordPreview()
}

@Preview(
    showBackground = true, name = "enable text field  password error",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun TextFieldTypePasswordErrorPreview() {
    StoryAppTheme {
        Surface {
            TextFieldTypePassword(
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
    showBackground = true, name = "dark mode enable text field password error",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun TextFieldTypePasswordErrorDarkModePreview() {
    TextFieldTypePasswordErrorPreview()
}