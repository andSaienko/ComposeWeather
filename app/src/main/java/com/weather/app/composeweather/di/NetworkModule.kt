package com.weather.app.composeweather.di

import com.weather.app.composeweather.data.api.OkHttpClientImpl
import com.weather.app.composeweather.data.api.RetrofitProvider
import com.weather.app.composeweather.data.api.WeatherApiServiceProvider
import com.weather.app.composeweather.data.api.WeatherApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {

    factory<OkHttpClient> {
        OkHttpClientImpl().provideOkHttpClient()
    }

    factory<Retrofit> {
        RetrofitProvider(okHttpClient = get()).provideRetrofit()
    }

    factory<WeatherApi> {
        WeatherApiServiceProvider().provideWeatherApiService(retrofit = get())
    }
}