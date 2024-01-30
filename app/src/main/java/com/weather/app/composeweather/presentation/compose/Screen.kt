package com.weather.app.composeweather.presentation.compose

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.weather.app.composeweather.data.model.response.HourDTO

sealed class Screen(
    val route: String,
    val navArgs: List<NamedNavArgument> = emptyList()
) {
    data object Home : Screen("homeScreen")

    data object HourDetails : Screen(
        route = "moreHourInfo/{city}/{hour}",
        navArgs = listOf(navArgument("hourWeatherInfo") {
            type = NavType.ParcelableType(HourDTO::class.java)
        })
    ) {
        fun createRoute(city: String, hour: String) = "moreHourInfo/${city}/${hour}"
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