package com.weather.app.composeweather.data.model.response

import com.google.gson.annotations.SerializedName

data class AstroDTO(
    val sunrise: String? = null,
    val sunset: String? = null,
    val moonrise: String? = null,
    val moonset: String? = null,
    @SerializedName("moon_phase") val moonPhase: String? = null,
    @SerializedName("moon_illumination") val moonIllumination: Int? = null,
    @SerializedName("is_moon_up") val isMoonUp: Int? = null,
    @SerializedName("is_sun_up") val isSunUp: Int? = null,
)