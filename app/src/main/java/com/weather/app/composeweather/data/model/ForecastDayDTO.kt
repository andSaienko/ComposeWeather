package com.weather.app.composeweather.data.model

import com.google.gson.annotations.SerializedName

data class ForecastDayDTO(
    val date: String,
    @SerializedName("date_epoch") val dateEpoch: Int,
    val day: DayDTO,
    val astro: AstroDTO,
    val hour: ArrayList<HourDTO>,
)