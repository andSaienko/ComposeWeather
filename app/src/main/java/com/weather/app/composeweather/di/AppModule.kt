package com.weather.app.composeweather.di

import com.weather.app.composeweather.presentation.viewmodel.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<WeatherViewModel> {
        WeatherViewModel(
            getWeatherUseCase = get(), saveCityUseCase = get(), loadCityUseCase = get()
        )
    }
}