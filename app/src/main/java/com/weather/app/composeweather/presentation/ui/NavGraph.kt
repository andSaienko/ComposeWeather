package com.weather.app.composeweather.presentation.ui

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.weather.app.composeweather.presentation.ui.daydetails.DayDetailsScreen
import com.weather.app.composeweather.presentation.ui.homescreen.HomeScreen
import com.weather.app.composeweather.presentation.ui.hourdetails.HourDetailsScreen

@Composable
fun ComposeWeatherApp() {
    val navController = rememberNavController()
    ComposeWeatherNavHost(
        navController = navController
    )
}

@Composable
fun ComposeWeatherNavHost(
    navController: NavHostController
) {
    NavHost(navController = navController,
        startDestination = Screen.Home.route,
        enterTransition = { fadeIn(animationSpec = tween(ANIMATION_TIME)) },
        exitTransition = { fadeOut(animationSpec = tween(ANIMATION_TIME)) }) {
        composable(route = Screen.Home.route) {
            HomeScreen( navController = navController)
        }
        composable(route = Screen.HourDetails.route) {
            HourDetailsScreen(onBackClick = { navController.navigateUp() })
        }
        composable(route = Screen.DayDetails.route) {
            DayDetailsScreen(onBackClick = { navController.navigateUp() })
        }
    }
}

private const val ANIMATION_TIME = 350
