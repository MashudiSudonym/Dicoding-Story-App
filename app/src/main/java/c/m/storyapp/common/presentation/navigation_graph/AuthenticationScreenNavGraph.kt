package c.m.storyapp.common.presentation.navigation_graph

import com.ramcosta.composedestinations.annotation.NavGraph

@MainScreenNavGraph
@NavGraph
annotation class AuthenticationScreenNavGraph(
    val start: Boolean = false,
)