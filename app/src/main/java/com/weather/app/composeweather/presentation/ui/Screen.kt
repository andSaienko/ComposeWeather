package com.weather.app.composeweather.presentation.ui

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(
    val route: String, val navArgs: List<NamedNavArgument> = emptyList()
) {
    data object Home : Screen("homeScreen")

    data object HourDetails : Screen(
        route = "moreHourInfo/{hour}",
        navArgs = listOf(navArgument("hourInfo") {
            type = NavType.StringType
        })
    ) {
        fun createRoute(currentHour: String) = "moreHourInfo/${currentHour}"
    }

    data object DayDetails : Screen(
        route = "moreDayInfo/{day}",
        navArgs = listOf(navArgument("dayInfo") {
            type = NavType.StringType
        })
    ) {
        fun createRoute(currentDay: String) = "moreDayInfo/${currentDay}"
    }
}