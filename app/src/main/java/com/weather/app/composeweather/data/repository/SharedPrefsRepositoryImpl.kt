package com.weather.app.composeweather.data.repository

import android.content.SharedPreferences
import com.weather.app.composeweather.domain.repository.SharedPrefsRepository

class SharedPrefsRepositoryImpl(private val sharedPrefs: SharedPreferences) : SharedPrefsRepository {
    override suspend fun saveCity(city: String) {
        sharedPrefs.edit().putString(com.weather.app.composeweather.domain.CITY, city).apply()
    }
    override fun loadCity(): String? {
        return sharedPrefs.getString(com.weather.app.composeweather.domain.CITY, null)
    }
}