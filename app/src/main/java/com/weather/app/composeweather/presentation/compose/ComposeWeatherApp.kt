package com.weather.app.composeweather.presentation.compose

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.weather.app.composeweather.presentation.compose.daydetails.DayDetailsScreen
import com.weather.app.composeweather.presentation.compose.homescreen.HomeScreen
import com.weather.app.composeweather.presentation.compose.hourdetails.HourDetailsScreen

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
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        enterTransition = { fadeIn(animationSpec = tween(350)) },
        exitTransition = { fadeOut(animationSpec = tween(350)) }
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(route = Screen.HourDetails.route) {
            HourDetailsScreen(
                onBackClick = { navController.navigateUp() }
            )
        }
        composable(route = Screen.DayDetails.route) {
            DayDetailsScreen(
                onBackClick = { navController.navigateUp() }
            )
        }
    }
}
