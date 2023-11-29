package com.weather.app.composeweather.domain.repository

interface SharedPrefsRepository {
    suspend fun saveCity(city: String)
    fun loadCity(): String?
}