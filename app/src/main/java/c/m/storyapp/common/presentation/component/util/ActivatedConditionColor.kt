package c.m.storyapp.common.presentation.component.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * this file is used to store custom color settings that will be used repeatedly in jetpack compose files.
 */

// If you need dynamic background color on enable or disable item condition for ui component
@Composable
fun ActivatedConditionColor(isEnable: Boolean, enabled: Color, disabled: Color): Color =
    if (isEnable) {
        enabled
    } else {
        disabled
    }