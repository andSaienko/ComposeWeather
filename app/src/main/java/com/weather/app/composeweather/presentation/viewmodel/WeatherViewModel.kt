package com.weather.app.composeweather.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.app.composeweather.data.model.request.WeatherRequestDTO
import com.weather.app.composeweather.domain.model.WeatherResponseDTO
import com.weather.app.composeweather.domain.usecase.GetWeatherUseCase
import com.weather.app.composeweather.domain.usecase.LoadCityUseCase
import com.weather.app.composeweather.domain.usecase.SaveCityUseCase
import com.weather.app.composeweather.presentation.event.ViewAction
import com.weather.app.composeweather.presentation.intent.ViewIntent
import com.weather.app.composeweather.presentation.state.ViewState
import com.weather.core.network.error
import com.weather.core.network.execute
import com.weather.core.network.networkExecutor
import com.weather.core.network.success
import com.weather.mvi_base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class WeatherViewModel(
    private val saveCityUseCase: SaveCityUseCase,
    private val loadCityUseCase: LoadCityUseCase,
    private val getWeatherUseCase: GetWeatherUseCase,
) : BaseViewModel<ViewIntent, ViewAction, ViewState>, ViewModel() {

    override val viewState = MutableStateFlow<ViewState>(ViewState.Loading)

    init {
        val action = handleIntent(ViewIntent.Initial("Kyiv"))
        handleAction(action)
    }

    override fun handleIntent(intent: ViewIntent): ViewAction {
        return when (intent) {
            is ViewIntent.Initial -> ViewAction.SearchWeather
            is ViewIntent.Search -> ViewAction.SearchWeather
            is ViewIntent.Refresh -> ViewAction.RefreshCurrent
        }
    }

    override fun handleAction(action: ViewAction) {
        when (action) {
            is ViewAction.SearchWeather -> {
                getWeather("Kyiv")
            }

            is ViewAction.RefreshCurrent -> {

            }
        }
    }

    fun getWeather(city: String) {
        viewModelScope.launch {

//          Only for visual
            delay(300L)

            networkExecutor<WeatherResponseDTO> {
                execute { getWeatherUseCase(WeatherRequestDTO(city)) }
                success {
                    viewState.value = ViewState.DataCollected(data = it)
                    saveActualCity(city)
                }
                error { viewState.value = ViewState.Error }
            }
        }
    }

    private fun saveActualCity(city: String) {
        viewModelScope.launch {
            saveCityUseCase(city)
        }
    }

    fun loadActualCity(): String {
        return loadCityUseCase()
    }
}