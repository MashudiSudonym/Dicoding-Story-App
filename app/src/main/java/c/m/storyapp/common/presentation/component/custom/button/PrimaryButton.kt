package c.m.storyapp.common.presentation.component.custom.button

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import c.m.storyapp.common.presentation.component.util.AdaptiveThemeColor
import c.m.storyapp.common.presentation.ui.theme.Emerald
import c.m.storyapp.common.presentation.ui.theme.Gray20
import c.m.storyapp.common.presentation.ui.theme.StoryAppTheme

@Composable
fun PrimaryButton(
    modifier: Modifier,
    textButton: String,
    isEnable: Boolean = true,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = AdaptiveThemeColor(
            isDarkTheme = isSystemInDarkTheme(),
            onDark = Color.White,
            onLight = Emerald,
        ),
        disabledContainerColor = Gray20,
        contentColor = AdaptiveThemeColor(
            isDarkTheme = isSystemInDarkTheme(),
            onDark = Emerald,
            onLight = Color.White,
        ),
        disabledContentColor = Color.White,
    ),
    onClick: () -> Unit = {},
) {
    Button(
        modifier = modifier,
        enabled = isEnable,
        colors = buttonColors,
        onClick = onClick,
    ) {
        Text(
            text = textButton,
            fontWeight = FontWeight.Normal,
        )
    }
}

@Preview(
    showBackground = true, name = "enable button",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun PrimaryButtonPreview() {
    StoryAppTheme {
        Surface {
            PrimaryButton(
                modifier = Modifier,
                textButton = "Text",
            )
        }
    }
}

@Preview(
    showBackground = true, name = "dark mode enable button",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun PrimaryButtonDarkPreview() {
    PrimaryButtonPreview()
}

@Preview(
    showBackground = true, name = "enable button custom color",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun PrimaryButtonCustomColorPreview() {
    StoryAppTheme {
        Surface {
            PrimaryButton(
                modifier = Modifier,
                textButton = "Text",
                buttonColors = ButtonDefaults.buttonColors(
                    contentColor = Color.Magenta,
                    containerColor = Color.Green,
                ),
            )
        }
    }
}

@Preview(
    showBackground = true, name = "dark mode enable button custom color",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun PrimaryButtonDarkCustomColorPreview() {
    PrimaryButtonCustomColorPreview()
}

@Preview(
    showBackground = true, name = "disable button",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun PrimaryButtonDisablePreview() {
    StoryAppTheme {
        Surface {
            PrimaryButton(
                modifier = Modifier,
                textButton = "Text",
                isEnable = false,
            )
        }
    }
}

@Preview(
    showBackground = true, name = "dark mode disable button",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun PrimaryButtonDarkDisablePreview() {
    PrimaryButtonDisablePreview()
}