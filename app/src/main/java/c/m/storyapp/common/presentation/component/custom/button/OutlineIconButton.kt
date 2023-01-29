package c.m.storyapp.common.presentation.component.custom.button

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import c.m.storyapp.common.presentation.component.util.ActivatedConditionColor
import c.m.storyapp.common.presentation.component.util.AdaptiveThemeColor
import c.m.storyapp.common.presentation.ui.theme.Emerald
import c.m.storyapp.common.presentation.ui.theme.Gray20
import c.m.storyapp.common.presentation.ui.theme.StoryAppTheme

@Composable
fun OutlineIconButton(
    modifier: Modifier,
    isEnable: Boolean = true,
    icon: ImageVector,
    contentDescription: String? = null,
    tintColor: Color = ActivatedConditionColor(
        isEnable = isEnable,
        enabled = AdaptiveThemeColor(
            isDarkTheme = isSystemInDarkTheme(),
            onDark = Color.White,
            onLight = Emerald,
        ),
        disabled = Gray20,
    ),
    border: BorderStroke = BorderStroke(
        width = Dp.Hairline, ActivatedConditionColor(
            isEnable = isEnable,
            enabled = AdaptiveThemeColor(
                isDarkTheme = isSystemInDarkTheme(),
                onDark = Color.White,
                onLight = Emerald,
            ),
            disabled = Gray20,
        )
    ),
    onClick: () -> Unit = {},
) {
    OutlinedIconButton(
        modifier = modifier,
        enabled = isEnable,
        border = border,
        onClick = onClick,
    ) {
        Icon(imageVector = icon, contentDescription = contentDescription, tint = tintColor)
    }
}

@Preview(
    showBackground = true, name = "enable button",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun OutlineIconButtonPreview() {
    StoryAppTheme {
        Surface {
            OutlineIconButton(
                modifier = Modifier,
                icon = Icons.Sharp.ArrowBack,
                contentDescription = "text",
            )
        }
    }
}

@Preview(
    showBackground = true, name = "dark mode enable button",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun OutlineIconButtonDarkModePreview() {
    OutlineIconButtonPreview()
}

@Preview(
    showBackground = true, name = "disable button",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun OutlineIconButtonDisablePreview() {
    StoryAppTheme {
        Surface {
            OutlineIconButton(
                modifier = Modifier,
                isEnable = false,
                icon = Icons.Default.ArrowBack,
                contentDescription = "Back Button",
            )
        }
    }
}

@Preview(
    showBackground = true, name = "dark mode disable button",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun OutlineIconButtonDisableDarkModePreview() {
    OutlineIconButtonDisablePreview()
}