package com.weather.app.composeweather.data.api

import okhttp3.OkHttpClient

interface CusOkHttpClient {
    fun provideOkHttpClient(): OkHttpClient
}