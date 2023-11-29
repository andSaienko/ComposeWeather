package com.weather.app.composeweather.data.api

import com.weather.app.composeweather.data.model.request.WeatherRequestDTO
import com.weather.app.composeweather.domain.model.WeatherResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "a10413adcf6f4749806201122232111"

interface WeatherApi {

    @GET("/v1/forecast.json?key=$API_KEY&days=10&aqi=no&alerts=no")
    suspend fun getWeather(
        @Query("q") city: WeatherRequestDTO,
    ): WeatherResponseDTO
}