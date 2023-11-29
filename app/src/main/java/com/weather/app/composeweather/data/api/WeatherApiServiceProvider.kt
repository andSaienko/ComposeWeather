package com.weather.app.composeweather.data.api

import retrofit2.Retrofit

class WeatherApiServiceProvider : WeatherApiService {
    override fun provideWeatherApiService(retrofit: Retrofit): WeatherApi {
        return retrofit.create(WeatherApi::class.java)
    }
}