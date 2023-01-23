package c.m.storyapp.common.presentation.component.bottom_navigation_bar

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import c.m.storyapp.NavGraphs
import c.m.storyapp.appCurrentDestinationAsState
import c.m.storyapp.destinations.Destination
import c.m.storyapp.startAppDestination
import com.ramcosta.composedestinations.navigation.navigate


@Composable
fun BottomNavigationBar(navController: NavController) {
    val currentDestination: Destination =
        navController.appCurrentDestinationAsState().value ?: NavGraphs.root.startAppDestination

    // Navigation Bar : https://m3.material.io/components/navigation-bar/overview
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
    ) {
        BottomNavigationBarDestination.values().forEach { destination ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    selectedTextColor = MaterialTheme.colorScheme.onSurface,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    indicatorColor = MaterialTheme.colorScheme.secondaryContainer,
                ),
                selected = currentDestination == destination.direction,
                onClick = {
                    navController.navigate(destination.direction) {
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = destination.icon,
                        contentDescription = stringResource(id = destination.label),
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = destination.label),
                        style = MaterialTheme.typography.labelMedium,
                    )
                },
            )
        }
    }
}