package com.weather.app.composeweather.domain.model

import com.google.gson.annotations.SerializedName
import com.weather.app.composeweather.data.model.response.CurrentWeatherDTO
import com.weather.app.composeweather.data.model.response.ForecastDTO
import com.weather.app.composeweather.data.model.response.LocationDTO

data class WeatherResponseDTO(
    val location: LocationDTO,
    val current: CurrentWeatherDTO,
    val forecast: ForecastDTO,
)