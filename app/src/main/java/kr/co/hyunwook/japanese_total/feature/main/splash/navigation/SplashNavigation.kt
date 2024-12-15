package kr.co.hyunwook.japanese_total.feature.main.splash.navigation

import kotlinx.serialization.Serializable
import kr.co.hyunwook.japanese_total.core.navigation.Route
import kr.co.hyunwook.japanese_total.feature.main.splash.SplashScreen
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.splashNavGraph(
    navigateToOnBoarding: () -> Unit
) {
    composable<Splash> {
        SplashScreen(
            navigateToOnBoarding = navigateToOnBoarding
        )
    }
}

@Serializable
data object Splash: Route {
    override val route = " r.co.hyunwook.japanese_total.feature.main.splash.navigation.Splash"
}