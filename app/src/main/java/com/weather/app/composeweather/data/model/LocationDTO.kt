package com.weather.app.composeweather.data.model

import com.google.gson.annotations.SerializedName

data class LocationDTO(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    @SerializedName("tz_id") val tzId: String,
    @SerializedName("localtime_epoch") val localtimeEpoch: Int,
    val localtime: String,
)