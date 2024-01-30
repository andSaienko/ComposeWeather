package com.weather.app.composeweather.presentation.state

import com.weather.app.composeweather.domain.model.WeatherResponseDTO
import com.weather.mvi_base.BaseState

sealed class ViewState : BaseState {
    sealed class RoutingState : ViewState() {
        object Loading : RoutingState()
        object Error : RoutingState()
    }
    data class DataCollected(val data: WeatherResponseDTO) : ViewState()
}