package com.weather.app.composeweather.presentation.ui.hourdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.weather.app.composeweather.presentation.state.ViewState
import com.weather.app.composeweather.presentation.viewmodel.HomeViewModel
import com.weather.core.ui.theme.LightBlue
import org.koin.androidx.compose.getViewModel

@Composable
fun HourDetailsScreen(
    viewModel: HomeViewModel = getViewModel(), inputHour: String?
) {
    val statusBarHeight = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
    val navBarHeight = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()

    val state by viewModel.state.collectAsState()
    val data = (state as ViewState.DataCollected).data

    val hourDetailsDataList: MutableList<HourInfo> = mutableListOf()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = LightBlue)
            .padding(bottom = navBarHeight + 8.dp, start = 8.dp, end = 8.dp, top = statusBarHeight),
        contentAlignment = Alignment.Center
    ) {
        Card(
            colors = CardDefaults.cardColors(Color(0x80F1FEFF)),
            elevation = CardDefaults.cardElevation(0.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                data.forecast.forecastDay[0].hour.forEach { hour ->
                    if (hour.time == inputHour) {
                        AsyncImage(
                            modifier = Modifier
                                .size(88.dp)
                                .padding(top = 24.dp),
                            model = "https://${hour.condition.icon}",
                            contentDescription = "weather icon"
                        )
                        hourDetailsDataList.add(HourInfo(infoType = "Temperature", infoValue = "${hour.tempC} ºС"))
                        hourDetailsDataList.add(HourInfo(infoType = "Wind speed", infoValue = "${hour.windKph} km/h"))
                        hourDetailsDataList.add(HourInfo(infoType = "Wind degree", infoValue = hour.windDegree.toString()))
                        hourDetailsDataList.add(HourInfo(infoType = "Pressure", infoValue = hour.pressureIn.toString()))
                        hourDetailsDataList.add(HourInfo(infoType = "Humidity", infoValue = hour.humidity.toString()))
                        hourDetailsDataList.add(HourInfo(infoType = "Cloud", infoValue = hour.cloud.toString()))
                        hourDetailsDataList.add(HourInfo(infoType = "Feels like", infoValue = "${hour.feelsLikeC} ºС"))
                        hourDetailsDataList.add(HourInfo(infoType = "Will it rain", infoValue = if (hour.willItRain == 0) "No" else "Yes"))
                    }
                }
                Text(text = data.location.name, fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color(0xC0000000))
                Text(text = inputHour?.substring(11).toString(), fontSize = 22.sp, color = Color(0xC0000000))

                LazyVerticalGrid(columns = GridCells.Adaptive(128.dp), modifier = Modifier.padding(top = 24.dp), content = {
                    items(hourDetailsDataList.size) { index ->
                        Card(
                            colors = CardDefaults.cardColors(Color(0x80F1FEFF)),
                            elevation = CardDefaults.cardElevation(0.dp),
                            shape = RoundedCornerShape(16.dp),
                            modifier = Modifier.padding(4.dp)
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = hourDetailsDataList[index].infoType, modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                                )
                                Text(
                                    text = hourDetailsDataList[index].infoValue,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                                )
                            }
                        }
                    }
                })
            }
        }
    }
}

private data class HourInfo(val infoType: String, val infoValue: String)