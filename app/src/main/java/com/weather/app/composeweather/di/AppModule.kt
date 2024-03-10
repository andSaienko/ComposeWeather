package com.weather.app.composeweather.di

import com.weather.app.composeweather.presentation.viewmodel.HomeViewModel
import org.koin.dsl.module

val appModule = module {

    single<HomeViewModel> {
        HomeViewModel(
            getWeatherUseCase = get(), saveCityUseCase = get(), loadCityUseCase = get()
        )
    }
}