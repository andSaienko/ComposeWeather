package com.weather.app.composeweather.di

import com.weather.app.composeweather.domain.usecase.GetWeatherUseCase
import com.weather.app.composeweather.domain.usecase.LoadCityUseCase
import com.weather.app.composeweather.domain.usecase.SaveCityUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetWeatherUseCase> {
        GetWeatherUseCase(repository = get())
    }
    factory<SaveCityUseCase> {
        SaveCityUseCase(repository = get())
    }
    factory<LoadCityUseCase> {
        LoadCityUseCase(repository = get())
    }
}