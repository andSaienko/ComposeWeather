package com.weather.app.composeweather.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.app.composeweather.domain.model.WeatherResponseDTO
import com.weather.app.composeweather.domain.usecase.GetWeatherUseCase
import com.weather.app.composeweather.domain.usecase.LoadCityUseCase
import com.weather.app.composeweather.domain.usecase.SaveCityUseCase
import com.weather.app.composeweather.presentation.intent.ViewIntent
import com.weather.app.composeweather.presentation.state.ViewState
import com.weather.core.network.error
import com.weather.core.network.execute
import com.weather.core.network.networkExecutor
import com.weather.core.network.success
import com.weather.mvi_base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val saveCityUseCase: SaveCityUseCase,
    private val loadCityUseCase: LoadCityUseCase,
    private val getWeatherUseCase: GetWeatherUseCase,
) : BaseViewModel<ViewIntent, ViewState>, ViewModel() {

    private val _state = MutableStateFlow<ViewState>(ViewState.RoutingState.Loading)
    override val state: StateFlow<ViewState> = _state

    init {
        processIntent(ViewIntent.Initial(loadCityUseCase()))
    }

    override fun processIntent(intent: ViewIntent) {
        when (intent) {
            is ViewIntent.Initial -> getWeather(loadCityUseCase())
            is ViewIntent.SearchIntent -> getWeather(intent.cityName)
            is ViewIntent.RefreshIntent -> getWeather(loadCityUseCase())
        }
    }

    private fun getWeather(city: String) {
        viewModelScope.launch {
//          Only for visual for test bad connection
            delay(300L)

            networkExecutor<WeatherResponseDTO> {
                execute { getWeatherUseCase(city) }
                success {
                    _state.value = ViewState.DataCollected(data = it)
                    saveActualCity(city)
                }
                error {
                    _state.value = ViewState.RoutingState.Error
                    delay(1000L)
                    processIntent(ViewIntent.Initial(loadCityUseCase()))
                }
            }
        }
    }

    private fun saveActualCity(city: String) {
        viewModelScope.launch {
            saveCityUseCase(city)
        }
    }
}