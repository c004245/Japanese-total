package kr.co.hyunwook.japanese_total.feature.main.splash

sealed class SplashSideEffect {
    data object NavigateToOnBoarding: SplashSideEffect()
}
