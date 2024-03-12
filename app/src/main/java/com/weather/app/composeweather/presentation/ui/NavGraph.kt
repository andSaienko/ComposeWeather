package com.weather.app.composeweather.presentation.ui

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.weather.app.composeweather.presentation.ui.daydetails.DayDetailsScreen
import com.weather.app.composeweather.presentation.ui.homescreen.HomeScreen
import com.weather.app.composeweather.presentation.ui.hourdetails.HourDetailsScreen

@Composable
fun ComposeWeatherApp(navController: NavHostController = rememberNavController()) {
    WeatherNavHost(navController = navController)
}

@Composable
fun WeatherNavHost(
    navController: NavHostController
) {
    NavHost(navController = navController,
        startDestination = Screen.Home.route,
        enterTransition = { fadeIn(animationSpec = tween(ANIMATION_TIME)) },
        exitTransition = { fadeOut(animationSpec = tween(ANIMATION_TIME)) }) {

        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.HourDetails.route,
            arguments = listOf(navArgument("inputHour") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            HourDetailsScreen(inputHour = backStackEntry.arguments?.getString("inputHour"))
        }
        composable(
            route = Screen.DayDetails.route,
            arguments = listOf(navArgument("inputDay") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            DayDetailsScreen(inputDay = backStackEntry.arguments?.getString("inputDay"))
        }
    }
}

private const val ANIMATION_TIME = 350
