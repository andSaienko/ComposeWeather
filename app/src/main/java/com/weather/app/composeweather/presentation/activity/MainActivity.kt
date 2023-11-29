package com.weather.app.composeweather.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.lifecycle.lifecycleScope
import com.weather.app.composeweather.domain.enums.Cities
import com.weather.app.composeweather.presentation.intent.WeatherIntent
import com.weather.app.composeweather.presentation.state.ViewModelState
import com.weather.app.composeweather.presentation.ui.HourDayTabLayout
import com.weather.app.composeweather.presentation.ui.LoadingWidget
import com.weather.app.composeweather.presentation.ui.LottieAnim
import com.weather.app.composeweather.presentation.ui.WeatherWidget
import com.weather.app.composeweather.presentation.viewmodel.WeatherViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val vm by viewModel<WeatherViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setObservers()
        handleIntents()
    }

    private fun setObservers() {
        lifecycleScope.launch {
            vm.state.collect { state ->
                renderState(state)
            }
        }
    }

    private fun handleIntents() {
        lifecycleScope.launch {
            vm.sendIntent(WeatherIntent.LoadWeather(city = Cities.DEFAULT_CITY.value))
        }
    }

    private fun renderState(state: ViewModelState) {
        when (state) {
            is ViewModelState.IdleState -> Unit

            is ViewModelState.LoadingState -> {
                setContent {
                    LoadingWidget()
                }
            }

            is ViewModelState.WeatherInfoState -> {
                setContent {
                    LottieAnim(data = state.data)
                    Column {
                        WeatherWidget(data = state.data)
                        HourDayTabLayout(data = state.data)
                    }
                }
            }

            is ViewModelState.ErrorState -> {}

        }
    }
}
