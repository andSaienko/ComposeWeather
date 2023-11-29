package com.weather.app.composeweather.di

import com.weather.app.composeweather.data.api.WeatherApi
import com.weather.app.composeweather.data.api.WeatherApiServiceProvider
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    factory<OkHttpClient> {
        provideOkHttpClient()
    }

    factory<Retrofit> {
        provideRetrofit(okHttpClient = get())
    }

    factory<WeatherApi> {
        WeatherApiServiceProvider().provideWeatherApiService(retrofit = get())
    }
}

fun provideOkHttpClient(): OkHttpClient {
    val createAuthInterceptor = Interceptor { chain ->
        chain.proceed(chain.request().newBuilder().build())
    }

    return OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .addInterceptor(createAuthInterceptor)
        .build()
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api.weatherapi.com")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}