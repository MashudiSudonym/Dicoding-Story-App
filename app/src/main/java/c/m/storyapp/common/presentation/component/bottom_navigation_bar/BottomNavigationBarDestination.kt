package c.m.storyapp.common.presentation.component.bottom_navigation_bar

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Map
import androidx.compose.ui.graphics.vector.ImageVector
import c.m.storyapp.R
import c.m.storyapp.destinations.AddStoryScreenDestination
import c.m.storyapp.destinations.DirectionDestination
import c.m.storyapp.destinations.ListStoryScreenDestination
import c.m.storyapp.destinations.LocationStoryScreenDestination

enum class BottomNavigationBarDestination(
    val direction: DirectionDestination,
    val icon: ImageVector,
    @StringRes val label: Int,
) {
    ListStoryScreen(
        ListStoryScreenDestination,
        Icons.Rounded.Home,
        R.string.list_story,
    ),
    AddStoryScreen(
        AddStoryScreenDestination,
        Icons.Rounded.Add,
        R.string.add_story,
    ),
    LocationStoryScreen(
        LocationStoryScreenDestination,
        Icons.Rounded.Map,
        R.string.location_stories,
    ),
}