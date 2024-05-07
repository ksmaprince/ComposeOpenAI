package com.khun.composeopenai.navgation

sealed class Screen (val route: String){
    object Splash: Screen("splash_screen")
    object OnBoarding: Screen("onboarding_screen")
    object Message: Screen("message_screen")
}