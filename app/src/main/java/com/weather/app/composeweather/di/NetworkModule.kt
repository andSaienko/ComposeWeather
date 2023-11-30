package com.weather.app.composeweather.di

import com.weather.app.composeweather.data.api.BASE_URL
import com.weather.app.composeweather.data.api.WeatherApi
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
        provideWeatherApiService(retrofit = get())
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
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideWeatherApiService(retrofit: Retrofit): WeatherApi {
    return retrofit.create(WeatherApi::class.java)
}