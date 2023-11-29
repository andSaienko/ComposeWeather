package com.weather.app.composeweather.presentation.intent

sealed class WeatherIntent {
    data class LoadWeather(val city: String) : WeatherIntent()
    data class SaveCity(val city: String) : WeatherIntent()
    object RefreshInfo : WeatherIntent()
}
