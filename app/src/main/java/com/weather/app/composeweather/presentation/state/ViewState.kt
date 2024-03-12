package com.weather.app.composeweather.presentation.state

import com.weather.app.composeweather.domain.model.WeatherResponseDTO
import com.weather.mvi_base.BaseState

sealed class ViewState : BaseState {
    data object Loading : ViewState()
    data class DataCollected(val data: WeatherResponseDTO) : ViewState()
    data object Error : ViewState()
}