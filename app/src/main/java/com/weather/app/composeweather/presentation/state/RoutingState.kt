package com.weather.app.composeweather.presentation.state

sealed class RoutingState {
    object Loading : RoutingState()
    object Error : RoutingState()
}