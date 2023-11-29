package com.weather.app.composeweather.data.repository

import android.content.SharedPreferences
import com.weather.app.composeweather.domain.enums.SPrefKey
import com.weather.app.composeweather.domain.repository.SharedPrefsRepository

class SharedPrefsRepositoryImpl(private val sharedPrefs: SharedPreferences) : SharedPrefsRepository {
    override suspend fun saveCity(city: String) {
        sharedPrefs.edit().putString(SPrefKey.CITY.value, city).apply()
    }

    override fun loadCity(): String? {
        return sharedPrefs.getString(SPrefKey.CITY.value, "")
    }
}