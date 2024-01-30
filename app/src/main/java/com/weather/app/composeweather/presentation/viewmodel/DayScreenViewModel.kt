package com.weather.app.composeweather.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.weather.app.composeweather.domain.usecase.LoadCityUseCase

class DayScreenViewModel(
    private val loadCityUseCase: LoadCityUseCase,
) : ViewModel() {

}