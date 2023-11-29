package com.weather.app.composeweather.domain.sprefs

import android.content.Context
import android.content.SharedPreferences
import com.weather.app.composeweather.domain.enums.SPrefKey

class AppSharedPrefs(private val context: Context) {

    fun provideSharedPrefs(): SharedPreferences {
        return context.getSharedPreferences(SPrefKey.SPREFS.value, Context.MODE_PRIVATE)
    }
}