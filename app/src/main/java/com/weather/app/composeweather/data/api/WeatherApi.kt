package com.weather.app.composeweather.data.api

import com.weather.app.composeweather.domain.model.WeatherResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("/v1/forecast.json?key=$API_KEY&days=10&aqi=no&alerts=no")
    suspend fun getWeather(
        @Query("q") city: String,
    ): WeatherResponseDTO
}