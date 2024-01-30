package com.weather.app.composeweather.di

import com.weather.app.composeweather.presentation.viewmodel.DayScreenViewModel
import com.weather.app.composeweather.presentation.viewmodel.HomeScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<HomeScreenViewModel> {
        HomeScreenViewModel(
            getWeatherUseCase = get(),
            saveCityUseCase = get(),
            loadCityUseCase = get()
        )
    }
    viewModel<DayScreenViewModel> {
        DayScreenViewModel(
            loadCityUseCase = get()
        )
    }
}