package com.weather.app.composeweather.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.app.composeweather.data.model.request.WeatherRequestDTO
import com.weather.app.composeweather.domain.usecase.GetWeatherUseCase
import com.weather.app.composeweather.domain.usecase.LoadCityUseCase
import com.weather.app.composeweather.domain.usecase.SaveCityUseCase
import com.weather.app.composeweather.presentation.intent.WeatherIntent
import com.weather.app.composeweather.presentation.state.ViewModelState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch


class WeatherViewModel(
    private val saveCityUseCase: SaveCityUseCase,
    private val loadCityUseCase: LoadCityUseCase,
    private val getWeatherUseCase: GetWeatherUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<ViewModelState>(ViewModelState.IdleState)
    var state = _state.asStateFlow()

    // !! CHECH IT
    private val _intent = Channel<WeatherIntent>(Channel.UNLIMITED)

    val intent = _intent.receiveAsFlow()

    init {
//        getWeather(city = loadActualCity())
        handleIntent()
    }

    // add onrefresh clicked

    private fun handleIntent() {
        viewModelScope.launch {
            intent.collect { weatherIntent ->
                when (weatherIntent) {
                    is WeatherIntent.LoadWeather -> getWeather(weatherIntent.city)
                    is WeatherIntent.SaveCity -> saveActualCity(weatherIntent.city)
                    is WeatherIntent.RefreshInfo -> {}
                }
            }
        }
    }

    fun getWeather(city: String) {
        viewModelScope.launch {
            _state.value = ViewModelState.LoadingState

            // Only for visual
            delay(300L)

            val response = getWeatherUseCase(WeatherRequestDTO(city))
            _state.value = ViewModelState.WeatherInfoState(data = response)
        }
    }

    fun saveActualCity(city: String) {
        viewModelScope.launch {
            saveCityUseCase(city)
        }
    }

    fun loadActualCity(): String {
        return loadCityUseCase()
    }

    fun sendIntent(intent: WeatherIntent) {
        viewModelScope.launch {
            _intent.send(intent)
        }
    }
}