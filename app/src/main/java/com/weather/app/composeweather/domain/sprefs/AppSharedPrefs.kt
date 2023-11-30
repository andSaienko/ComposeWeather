package com.weather.app.composeweather.domain.sprefs

import android.content.Context
import android.content.SharedPreferences

class AppSharedPrefs(private val context: Context) {

    fun provideSharedPrefs(): SharedPreferences {
        return context.getSharedPreferences(com.weather.app.composeweather.domain.SPREFS, Context.MODE_PRIVATE)
    }
}