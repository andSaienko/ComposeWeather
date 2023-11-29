package com.weather.app.composeweather.data.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class OkHttpClientImpl : CusOkHttpClient {
    override fun provideOkHttpClient(): OkHttpClient {
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
}