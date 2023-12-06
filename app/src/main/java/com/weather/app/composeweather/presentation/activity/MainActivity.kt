package com.weather.app.composeweather.presentation.activity

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import com.weather.app.composeweather.presentation.event.ViewAction
import com.weather.app.composeweather.presentation.intent.ViewIntent
import com.weather.app.composeweather.presentation.state.ViewState
import com.weather.app.composeweather.presentation.ui.HourDayTabLayout
import com.weather.app.composeweather.presentation.ui.LoadingWidget
import com.weather.app.composeweather.presentation.ui.LottieAnim
import com.weather.app.composeweather.presentation.ui.WeatherWidget
import com.weather.app.composeweather.presentation.viewmodel.WeatherViewModel
import com.weather.mvi_base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ViewIntent, ViewState, ViewAction, WeatherViewModel>() {
    override val vm by viewModel<WeatherViewModel>()
    override fun renderState(state: ViewState) {
        when (state) {

            is ViewState.Loading -> {
                setContent {
                    LoadingWidget()
                }
            }

            is ViewState.DataCollected -> {
                setContent {
                    LottieAnim(data = state.data)
                    Column {
                        WeatherWidget(data = state.data)
                        HourDayTabLayout(data = state.data)
                    }
                }
            }

            is ViewState.Error -> Unit
        }
    }
}
