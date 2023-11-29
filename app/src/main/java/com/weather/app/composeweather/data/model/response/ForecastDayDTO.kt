package com.weather.app.composeweather.data.model.response

import com.google.gson.annotations.SerializedName

data class ForecastDayDTO(
    @SerializedName("date") var date: String? = null,
    @SerializedName("date_epoch") var dateEpoch: Int? = null,
    @SerializedName("day") var day: DayDTO? = DayDTO(),
    @SerializedName("astro") var astro: AstroDTO? = AstroDTO(),
    @SerializedName("hour") var hour: ArrayList<HourDTO> = arrayListOf(),
)