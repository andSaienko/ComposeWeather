package com.weather.app.composeweather.data.model.response

import com.google.gson.annotations.SerializedName


data class ForecastDTO(
    val forecastday: List<ForecastDayDTO> = listOf(),
)

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

data class ConditionDTO(
    val text: String? = null,
    val icon: String? = null,
    val code: Int? = null,
)

data class CurrentWeatherDTO(
    @SerializedName("last_updated_epoch") val lastUpdatedEpoch: Int? = null,
    @SerializedName("last_updated") val lastUpdated: String? = null,
    @SerializedName("temp_c") val tempC: Double? = null,
    @SerializedName("temp_f") val tempF: Double? = null,
    @SerializedName("is_day") val isDay: Int? = null,
    @SerializedName("condition") val condition: ConditionDTO? = ConditionDTO(),
    @SerializedName("wind_mph") val windMph: Double? = null,
    @SerializedName("wind_kph") val windKph: Double? = null,
    @SerializedName("wind_degree") val windDegree: Int? = null,
    @SerializedName("wind_dir") val windDir: String? = null,
    @SerializedName("pressure_mb") val pressureMb: Int? = null,
    @SerializedName("pressure_in") val pressureIn: Double? = null,
    @SerializedName("precip_mm") val precipMm: Double? = null,
    @SerializedName("precip_in") val precipIn: Double? = null,
    @SerializedName("humidity") val humidity: Int? = null,
    @SerializedName("cloud") val cloud: Int? = null,
    @SerializedName("feelslike_c") val feelslikeC: Double? = null,
    @SerializedName("feelslike_f") val feelslikeF: Double? = null,
    @SerializedName("vis_km") val visKm: Double? = null,
    @SerializedName("vis_miles") val visMiles: Int? = null,
    @SerializedName("uv") val uv: Int? = null,
    @SerializedName("gust_mph") val gustMph: Double? = null,
    @SerializedName("gust_kph") val gustKph: Double? = null,
)

data class DayDTO(
    @SerializedName("maxtemp_c") val maxtempC: Double? = null,
    @SerializedName("maxtemp_f") val maxtempF: Double? = null,
    @SerializedName("mintemp_c") val mintempC: Double? = null,
    @SerializedName("mintemp_f") val mintempF: Double? = null,
    @SerializedName("avgtemp_c") val avgtempC: Double? = null,
    @SerializedName("avgtemp_f") val avgtempF: Double? = null,
    @SerializedName("maxwind_mph") val maxwindMph: Double? = null,
    @SerializedName("maxwind_kph") val maxwindKph: Double? = null,
    @SerializedName("totalprecip_mm") val totalprecipMm: Double? = null,
    @SerializedName("totalprecip_in") val totalprecipIn: Double? = null,
    @SerializedName("totalsnow_cm") val totalsnowCm: Double? = null,
    @SerializedName("avgvis_km") val avgvisKm: Double? = null,
    @SerializedName("avgvis_miles") val avgvisMiles: Int? = null,
    @SerializedName("avghumidity") val avghumidity: Int? = null,
    @SerializedName("daily_will_it_rain") val dailyWillItRain: Int? = null,
    @SerializedName("daily_chance_of_rain") val dailyChanceOfRain: Int? = null,
    @SerializedName("daily_will_it_snow") val dailyWillItSnow: Int? = null,
    @SerializedName("daily_chance_of_snow") val dailyChanceOfSnow: Int? = null,
    @SerializedName("condition") val condition: ConditionDTO? = ConditionDTO(),
    @SerializedName("uv") val uv: Int? = null,
)

data class ForecastDayDTO(
    val date: String? = null,
    @SerializedName("date_epoch") val dateEpoch: Int? = null,
    val day: DayDTO? = DayDTO(),
    val astro: AstroDTO? = AstroDTO(),
    val hour: ArrayList<HourDTO> = arrayListOf(),
)

data class HourDTO(
    @SerializedName("time_epoch") val timeEpoch: Int? = null,
    @SerializedName("time") val time: String? = null,
    @SerializedName("temp_c") val tempC: Double? = null,
    @SerializedName("temp_f") val tempF: Double? = null,
    @SerializedName("is_day") val isDay: Int? = null,
    @SerializedName("condition") val condition: ConditionDTO? = ConditionDTO(),
    @SerializedName("wind_mph") val windMph: Double? = null,
    @SerializedName("wind_kph") val windKph: Double? = null,
    @SerializedName("wind_degree") val windDegree: Int? = null,
    @SerializedName("wind_dir") val windDir: String? = null,
    @SerializedName("pressure_mb") val pressureMb: Int? = null,
    @SerializedName("pressure_in") val pressureIn: Double? = null,
    @SerializedName("precip_mm") val precipMm: Double? = null,
    @SerializedName("precip_in") val precipIn: Double? = null,
    @SerializedName("humidity") val humidity: Int? = null,
    @SerializedName("cloud") val cloud: Int? = null,
    @SerializedName("feelslike_c") val feelslikeC: Double? = null,
    @SerializedName("feelslike_f") val feelslikeF: Double? = null,
    @SerializedName("windchill_c") val windchillC: Double? = null,
    @SerializedName("windchill_f") val windchillF: Double? = null,
    @SerializedName("heatindex_c") val heatindexC: Double? = null,
    @SerializedName("heatindex_f") val heatindexF: Double? = null,
    @SerializedName("dewpoint_c") val dewpointC: Double? = null,
    @SerializedName("dewpoint_f") val dewpointF: Double? = null,
    @SerializedName("will_it_rain") val willItRain: Int? = null,
    @SerializedName("chance_of_rain") val chanceOfRain: Int? = null,
    @SerializedName("will_it_snow") val willItSnow: Int? = null,
    @SerializedName("chance_of_snow") val chanceOfSnow: Int? = null,
    @SerializedName("vis_km") val visKm: Double? = null,
    @SerializedName("vis_miles") val visMiles: Int? = null,
    @SerializedName("gust_mph") val gustMph: Double? = null,
    @SerializedName("gust_kph") val gustKph: Double? = null,
    @SerializedName("uv") val uv: Int? = null,
)

data class LocationDTO(
    val name: String? = null,
    val region: String? = null,
    val country: String? = null,
    val lat: Double? = null,
    val lon: Double? = null,
    @SerializedName("tz_id") val tzId: String? = null,
    @SerializedName("localtime_epoch") val localtimeEpoch: Int? = null,
    val localtime: String? = null,
)