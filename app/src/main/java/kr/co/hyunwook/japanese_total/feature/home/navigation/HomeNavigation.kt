package kr.co.hyunwook.japanese_total.feature.home.navigation

import kotlinx.serialization.Serializable
import kr.co.hyunwook.japanese_total.core.navigation.Route
import kr.co.hyunwook.japanese_total.feature.home.HomeRoute
import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.homeNavGraph(
    paddingValues: PaddingValues
) {
    composable<Home> {
        HomeRoute(
            paddingValues = paddingValues
        )
    }
}

@Serializable
data object Home: Route {
    override val route = "kr.co.hyunwook.japanese_total.feature.home.navigation.Home"
}