package com.weather.app.composeweather

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import coil.Coil
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import coil.test.FakeImageLoaderEngine
import com.android.resources.Navigation
import com.weather.app.composeweather.data.model.response.HourDTO
import com.weather.app.composeweather.presentation.ui.items.WeatherHourListItem
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal sealed class ExampleUnitTest {

    @get:Rule
    abstract val paparazzi: Paparazzi

    @OptIn(ExperimentalCoilApi::class)
    @Before
    fun before() {
        val engine = FakeImageLoaderEngine.Builder()
            .intercept({ true }, ColorDrawable(Color.RED))
            .build()
        val imageLoader = ImageLoader.Builder(paparazzi.context)
            .components {
                add(engine)
            }
            .build()
        Coil.setImageLoader(imageLoader)
    }

    @Test
    fun testContentCompose() {
        paparazzi.snapshot {
            WeatherHourListItem(HourDTO())
        }
    }

    class EN : ExampleUnitTest() {
        override val paparazzi = Paparazzi(
            deviceConfig = DeviceConfig.PIXEL_5.copy(
                navigation = Navigation.DPAD
            )
        )
    }
}