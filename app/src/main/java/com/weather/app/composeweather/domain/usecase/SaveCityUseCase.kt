package com.weather.app.composeweather.domain.usecase

import com.weather.app.composeweather.domain.repository.SharedPrefsRepository

class SaveCityUseCase(private val repository: SharedPrefsRepository) {
    suspend operator fun invoke(city: String) {
        repository.saveCity(city)
    }
}