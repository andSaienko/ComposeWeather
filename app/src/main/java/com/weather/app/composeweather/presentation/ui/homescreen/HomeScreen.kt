package com.weather.app.composeweather.presentation.ui.homescreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.weather.app.composeweather.presentation.ui.routingscreen.RoutingWidget
import com.weather.app.composeweather.presentation.state.ViewState
import com.weather.app.composeweather.presentation.viewmodel.HomeViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = getViewModel(),
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