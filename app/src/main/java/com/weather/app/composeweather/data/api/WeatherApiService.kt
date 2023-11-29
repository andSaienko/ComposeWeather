package com.weather.app.composeweather.data.api

import retrofit2.Retrofit

interface WeatherApiService {
    fun provideWeatherApiService(retrofit: Retrofit): WeatherApi
}