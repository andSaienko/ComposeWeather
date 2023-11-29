package com.weather.app.composeweather.data.model.response

import com.google.gson.annotations.SerializedName

data class ConditionDTO(
    @SerializedName("text") var text: String? = null,
    @SerializedName("icon") var icon: String? = null,
    @SerializedName("code") var code: Int? = null,
)