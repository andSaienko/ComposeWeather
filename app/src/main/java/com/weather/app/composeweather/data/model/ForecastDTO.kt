package com.weather.app.composeweather.data.model

import com.google.gson.annotations.SerializedName

data class ForecastDTO(
    @SerializedName("forecastday") val forecastDay: List<ForecastDayDTO>
)