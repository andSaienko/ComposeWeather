package com.weather.app.composeweather.domain.usecase

import com.weather.app.composeweather.domain.model.WeatherResponseDTO
import com.weather.app.composeweather.domain.repository.WeatherRepository

class GetWeatherUseCase(private val repository: WeatherRepository) {
    suspend operator fun invoke(city: String): WeatherResponseDTO {
        return repository.getWeather(city)
    }
}