package com.khun.composeopenai.navgation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.khun.composeopenai.ui.screens.MessageScreen
import com.khun.composeopenai.ui.screens.OnBoardingScreen
import com.khun.composeopenai.ui.screens.SplashScreen
import com.khun.composeopenai.viewmodel.AppViewModel

@Composable
fun MainNavGraph(navController: NavHostController, viewModel: AppViewModel) {
    NavHost(
        navController = navController,
        route = "main_route",
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.OnBoarding.route) {
            OnBoardingScreen(navController = navController)
        }
        composable(route = Screen.Message.route) {
            MessageScreen(navController = navController, viewModel = viewModel)
        }
    }
}