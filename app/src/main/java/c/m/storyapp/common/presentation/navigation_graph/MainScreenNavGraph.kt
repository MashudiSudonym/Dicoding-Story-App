package c.m.storyapp.common.presentation.navigation_graph

import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph(start = true)
@NavGraph
annotation class MainScreenNavGraph(
    val start: Boolean = false,
)