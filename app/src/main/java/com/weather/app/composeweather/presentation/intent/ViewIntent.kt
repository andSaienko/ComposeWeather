package com.weather.app.composeweather.presentation.intent

import com.weather.mvi_base.BaseIntent

sealed interface ViewIntent : BaseIntent {
    data class Initial(val cityName: String) : ViewIntent
    data class SearchIntent(val cityName: String) : ViewIntent
    object RefreshIntent : ViewIntent
}