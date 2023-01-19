package c.m.storyapp.common.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import c.m.storyapp.common.presentation.ui.theme.StoryAppTheme
import com.ramcosta.composedestinations.annotation.Destination

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun RootScreen() {

}

@Preview(showBackground = true)
@Composable
private fun RootScreenPreview() {
    StoryAppTheme() {
        Surface {
            RootScreen()
        }
    }
}