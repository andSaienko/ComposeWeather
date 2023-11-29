package com.weather.app.composeweather.presentation.state

import com.weather.app.composeweather.domain.model.WeatherResponseDTO

sealed class ViewModelState {

    object IdleState : ViewModelState()

    object LoadingState : ViewModelState()

    data class WeatherInfoState(val data: WeatherResponseDTO) : ViewModelState()

    object ErrorState : ViewModelState()
}