package com.weather.app.composeweather.presentation.event

import com.weather.mvi_base.BaseAction

sealed interface ViewAction : BaseAction {

    object SearchWeather : ViewAction
    object RefreshCurrent : ViewAction
}