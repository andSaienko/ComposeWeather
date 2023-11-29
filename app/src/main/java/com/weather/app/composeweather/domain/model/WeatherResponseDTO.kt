package com.weather.app.composeweather.domain.model

import com.google.gson.annotations.SerializedName
import com.weather.app.composeweather.data.model.response.CurrentWeatherDTO
import com.weather.app.composeweather.data.model.response.ForecastDTO
import com.weather.app.composeweather.data.model.response.LocationDTO

data class WeatherResponseDTO(
    @SerializedName("location") var location: LocationDTO? = LocationDTO(),
    @SerializedName("current") var currentWeather: CurrentWeatherDTO? = CurrentWeatherDTO(),
    @SerializedName("forecast") var forecast: ForecastDTO? = ForecastDTO(),
)