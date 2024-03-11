package com.weather.app.composeweather.presentation.ui

sealed class Screen(
    val route: String
) {
    data object Home : Screen("homeScreen")

    data object HourDetails : Screen(
        route = "moreHourInfo/{inputHour}",
    ) {
        fun createRoute(hour: String) = "moreHourInfo/${hour}"
    }

    data object DayDetails : Screen(
        route = "moreDayInfo/{inputDay}"
    ) {
        fun createRoute(day: String) = "moreDayInfo/${day}"
    }
}