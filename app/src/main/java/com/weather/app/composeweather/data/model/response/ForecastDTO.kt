package com.weather.app.composeweather.data.model.response

data class ForecastDTO(
    val forecastday: List<ForecastDayDTO> = listOf(),
)