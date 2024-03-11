package com.weather.app.composeweather.presentation.ui.hourdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.weather.app.composeweather.presentation.state.ViewState
import com.weather.app.composeweather.presentation.viewmodel.HomeViewModel
import com.weather.core.ui.theme.LightBlue
import org.koin.androidx.compose.getViewModel

@Composable
fun HourDetailsScreen(
    viewModel: HomeViewModel = getViewModel(),
    inputHour: String?
) {
    val statusBarHeight = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
    val navBarHeight = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()

    val state by viewModel.state.collectAsState()
    val data = (state as ViewState.DataCollected).data

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = LightBlue)
            .padding(bottom = navBarHeight + 8.dp, start = 8.dp, end = 8.dp, top = statusBarHeight)
    ) {
        Card(
            modifier = Modifier.fillMaxSize(),
            colors = CardDefaults.cardColors(Color(0x80F1FEFF)),
            elevation = CardDefaults.cardElevation(0.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(modifier = Modifier.padding(8.dp)) {
                data.forecast.forecastDay[0].hour.forEach { hour ->
                    if (hour.time == inputHour) {
                        AsyncImage(
                            modifier = Modifier.size(64.dp), model = "https://${hour.condition.icon}", contentDescription = "weather icon"
                        )
                        Text(text = hour.cloud.toString())
                    }
                }
                Text(text = inputHour.toString())
                Text(text = data.current.tempC.toString())
                Text(text = data.current.windDir)
            }
        }
    }
}