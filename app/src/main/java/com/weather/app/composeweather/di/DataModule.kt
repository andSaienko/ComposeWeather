package com.weather.app.composeweather.di

import android.content.SharedPreferences
import com.weather.app.composeweather.data.repository.SharedPrefsRepositoryImpl
import com.weather.app.composeweather.data.repository.WeatherRepositoryImpl
import com.weather.app.composeweather.domain.repository.SharedPrefsRepository
import com.weather.app.composeweather.domain.repository.WeatherRepository
import com.weather.app.composeweather.domain.sprefs.AppSharedPrefs
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {

    single<SharedPreferences> {
        AppSharedPrefs(context = androidContext()).provideSharedPrefs()
    }

    single<SharedPrefsRepository> {
        SharedPrefsRepositoryImpl(sharedPrefs = get())
    }

    single<WeatherRepository> {
        WeatherRepositoryImpl(weatherApiService = get())
    }
}