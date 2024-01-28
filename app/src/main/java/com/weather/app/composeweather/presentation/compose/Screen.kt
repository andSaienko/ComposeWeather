package com.weather.app.composeweather.presentation.compose

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(
    val route: String,
    val navArgs: List<NamedNavArgument> = emptyList()
) {
    data object Home : Screen("homeScreen")

    data object HourDetails : Screen(
        route = "moreHourInfo/{cityName}",
        navArgs = listOf(navArgument("cityName") {
            type = NavType.StringType
        })
    ) {
        fun createRoute(cityName: String) = "moreHourInfo/${cityName}"
    }

    data object DayDetails : Screen(
        route = "moreDayInfo/{cityName}",
        navArgs = listOf(navArgument("cityName") {
            type = NavType.StringType
        })
    ) {
        fun createRoute(cityName: String) = "moreDayInfo/${cityName}"
    }
}