package com.weather.app.composeweather.data.model.response

import com.google.gson.annotations.SerializedName

data class AstroDTO(
    val sunrise: String,
    val sunset: String,
    val moonrise: String,
    val moonSet: String,
    @SerializedName("moon_phase") val moonPhase: String,
    @SerializedName("moon_illumination") val moonIllumination: Int,
    @SerializedName("is_moon_up") val isMoonUp: Int,
    @SerializedName("is_sun_up") val isSunUp: Int,
)