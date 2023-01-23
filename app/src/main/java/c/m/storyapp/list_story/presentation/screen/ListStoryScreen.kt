package c.m.storyapp.list_story.presentation.screen

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import c.m.storyapp.common.presentation.navigation_graph.MainScreenNavGraph
import c.m.storyapp.common.presentation.ui.theme.StoryAppTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator

@MainScreenNavGraph(start = true)
@Destination
@Composable
fun ListStoryScreen(navigator: DestinationsNavigator) {
    Text(text = "Hello World")
}

@Preview
@Composable
private fun ListStoryScreenDefaultPreview() {
    StoryAppTheme {
        Surface {
            ListStoryScreen(EmptyDestinationsNavigator)
        }
    }
}