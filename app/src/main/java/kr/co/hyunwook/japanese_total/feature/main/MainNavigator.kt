package kr.co.hyunwook.japanese_total.feature.main

import kr.co.hyunwook.japanese_total.core.navigation.Route
import kr.co.hyunwook.japanese_total.feature.home.navigation.Home
import kr.co.hyunwook.japanese_total.feature.main.onboarding.navigation.OnBoarding
import kr.co.hyunwook.japanese_total.feature.main.splash.navigation.Splash
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

class MainNavigator(
    val navController: NavHostController
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val startDestination = Splash

    fun navigateToOnBoarding(
        navOptions: NavOptions
    ) {
        navController.navigate(OnBoarding, navOptions = navOptions)
    }

    fun navigateToHome(
        navOptions: NavOptions
    ) {
        navController.navigate(Home, navOptions = navOptions)
    }

}



@Composable
internal fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}