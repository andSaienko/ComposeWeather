package com.weather.app.composeweather.app

import android.app.Application
import com.weather.app.composeweather.di.appModule
import com.weather.app.composeweather.di.dataModule
import com.weather.app.composeweather.di.domainModule
import com.weather.app.composeweather.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule, dataModule, domainModule, networkModule)
        }
    }
}