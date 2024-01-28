package com.weather.app.composeweather.presentation.compose.homescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.weather.app.composeweather.presentation.compose.routingscreen.RoutingTheme
import com.weather.app.composeweather.presentation.state.ViewState
import com.weather.app.composeweather.presentation.viewmodel.HomeScreenViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel = getViewModel()
) {
    val state by viewModel.state.collectAsState()
    val statusBarHeight = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()

    LottieAnim()

    when (state) {
        is ViewState.Loading -> {
            RoutingTheme(state = state)
        }

        is ViewState.DataCollected -> {
            Column(modifier = Modifier.padding(top = statusBarHeight)) {
                WeatherWidget(viewModel = viewModel, state = state)
                HourDayTabLayout(data = (state as ViewState.DataCollected).data, navController)
            }
        }

        is ViewState.Error -> {
            RoutingTheme(state = state)
        }
    }
}