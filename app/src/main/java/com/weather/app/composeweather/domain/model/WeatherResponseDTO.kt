package com.weather.app.composeweather.domain.model

import com.weather.app.composeweather.data.model.CurrentWeatherDTO
import com.weather.app.composeweather.data.model.ForecastDTO
import com.weather.app.composeweather.data.model.LocationDTO

data class WeatherResponseDTO(
    val location: LocationDTO,
    val current: CurrentWeatherDTO,
    val forecast: ForecastDTO,
)