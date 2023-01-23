package c.m.storyapp.list_story.presentation.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import c.m.storyapp.common.presentation.navigation_graph.MainScreenNavGraph
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@MainScreenNavGraph(start = true)
@Destination
@Composable
fun ListStoryScreen(navigator: DestinationsNavigator) {
    Text(text = "Hello World")
}