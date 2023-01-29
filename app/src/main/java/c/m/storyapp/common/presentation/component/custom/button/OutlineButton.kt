package c.m.storyapp.common.presentation.component.custom.button

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import c.m.storyapp.common.presentation.component.util.ActivatedConditionColor
import c.m.storyapp.common.presentation.component.util.AdaptiveThemeColor
import c.m.storyapp.common.presentation.ui.theme.Emerald
import c.m.storyapp.common.presentation.ui.theme.Gray20
import c.m.storyapp.common.presentation.ui.theme.StoryAppTheme

@Composable
fun OutlineButton(
    modifier: Modifier,
    textButton: String,
    isEnable: Boolean = true,
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(
        contentColor = AdaptiveThemeColor(
            isDarkTheme = isSystemInDarkTheme(),
            onDark = Color.White,
            onLight = Emerald,
        ),
        disabledContentColor = Gray20,
    ),
    border: BorderStroke = BorderStroke(
        width = Dp.Hairline,
        color = ActivatedConditionColor(
            isEnable = isEnable,
            enabled = AdaptiveThemeColor(
                isDarkTheme = isSystemInDarkTheme(),
                onDark = Color.White,
                onLight = Emerald,
            ),
            disabled = Gray20,
        ),
    ),
    onClick: () -> Unit = {},
) {
    OutlinedButton(
        modifier = modifier,
        enabled = isEnable,
        colors = colors,
        border = border,
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
private fun OutlineButtonPreview() {
    StoryAppTheme {
        Surface {
            OutlineButton(
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
private fun OutlineButtonDarkPreview() {
    OutlineButtonPreview()
}

@Preview(
    showBackground = true, name = "enable button custom border color",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun OutlineButtonCustomBorderColorPreview() {
    StoryAppTheme {
        Surface {
            OutlineButton(
                modifier = Modifier,
                textButton = "text",
                border = BorderStroke(
                    width = Dp.Hairline,
                    color = MaterialTheme.colorScheme.primary,
                )
            )
        }
    }
}

@Preview(
    showBackground = true, name = "dark mode enable button custom border color",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun OutlineButtonCustomBorderColorDarkPreview() {
    OutlineButtonCustomBorderColorPreview()
}

@Preview(
    showBackground = true, name = "enable button custom text color",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun OutlineButtonCustomTextColorPreview() {
    StoryAppTheme {
        Surface {
            OutlineButton(
                modifier = Modifier,
                textButton = "text",
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.Magenta,
                ),
            )
        }
    }
}

@Preview(
    showBackground = true, name = "dark mode enable button custom text color",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun OutlineButtonCustomTextColorDarkPreview() {
    OutlineButtonCustomTextColorPreview()
}

@Preview(
    showBackground = true, name = "disable button",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun OutlineButtonDisablePreview() {
    StoryAppTheme {
        Surface {
            OutlineButton(
                modifier = Modifier,
                textButton = "text",
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
private fun OutlineButtonDarkDisablePreview() {
    OutlineButtonDisablePreview()
}