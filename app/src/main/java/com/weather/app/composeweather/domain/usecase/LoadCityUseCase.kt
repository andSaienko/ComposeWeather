package com.weather.app.composeweather.domain.usecase

import com.weather.app.composeweather.domain.DEFAULT_CITY
import com.weather.app.composeweather.domain.repository.SharedPrefsRepository

class LoadCityUseCase(private val repository: SharedPrefsRepository) {
    operator fun invoke(): String {
        return repository.loadCity() ?: DEFAULT_CITY
    }
}