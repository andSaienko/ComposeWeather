package com.weather.app.composeweather.presentation.compose.homescreen

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.weather.app.composeweather.presentation.compose.routingscreen.RoutingWidget
import com.weather.app.composeweather.presentation.state.ViewState
import com.weather.app.composeweather.presentation.viewmodel.HomeScreenViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel = getViewModel(),
) {
    val state by viewModel.state.collectAsState()
    LottieAnim()

    when (state) {
        is ViewState.RoutingState -> {
            RoutingWidget(state = state)
        }

        is ViewState.DataCollected -> {
            WeatherWidget(viewModel = viewModel, navController = navController)
        }
    }
}