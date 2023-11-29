package com.weather.app.composeweather.domain.repository

import com.weather.app.composeweather.domain.model.WeatherResponseDTO

interface WeatherRepository {

    suspend fun getWeather(city: String): WeatherResponseDTO
}