package com.weather.app.composeweather.domain.usecase

import com.weather.app.composeweather.domain.enums.Cities
import com.weather.app.composeweather.domain.repository.SharedPrefsRepository

class LoadCityUseCase(private val repository: SharedPrefsRepository) {
    operator fun invoke(): String {
        return repository.loadCity() ?: Cities.DEFAULT_CITY.value
    }
}