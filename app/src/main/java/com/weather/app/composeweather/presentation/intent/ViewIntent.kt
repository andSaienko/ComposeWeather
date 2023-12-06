package com.weather.app.composeweather.presentation.intent

import com.weather.mvi_base.BaseIntent

sealed interface ViewIntent : BaseIntent {
    data class Initial(val cityName: String) : ViewIntent
    data class Search(val cityName: String) : ViewIntent
    object Refresh : ViewIntent
}