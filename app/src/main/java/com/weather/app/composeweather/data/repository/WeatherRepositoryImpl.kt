package com.weather.app.composeweather.data.repository

import com.weather.app.composeweather.data.api.WeatherApi
import com.weather.app.composeweather.data.model.request.WeatherRequestDTO
import com.weather.app.composeweather.domain.model.WeatherResponseDTO
import com.weather.app.composeweather.domain.repository.WeatherRepository

class WeatherRepositoryImpl(private val weatherApiService: WeatherApi) : WeatherRepository {
    override suspend fun getWeather(city: String): WeatherResponseDTO {
        return weatherApiService.getWeather(WeatherRequestDTO(city))
    }
}