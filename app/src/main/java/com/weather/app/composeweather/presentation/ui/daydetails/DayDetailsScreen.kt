package com.weather.app.composeweather.presentation.ui.daydetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.weather.app.composeweather.domain.model.DetailsInfo
import com.weather.app.composeweather.presentation.state.ViewState
import com.weather.app.composeweather.presentation.viewmodel.HomeViewModel
import com.weather.core.ui.theme.LightBlue
import org.koin.androidx.compose.getViewModel

@Composable
fun DayDetailsScreen(
    viewModel: HomeViewModel = getViewModel(),
    inputDay: String?
) {
    val state by viewModel.state.collectAsState()
    val data = (state as ViewState.DataCollected).data

    val hourDetailsDataList: MutableList<DetailsInfo> = mutableListOf()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = LightBlue)
            .padding(all = 8.dp),
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
                data.forecast.forecastDay.forEach { dataDay ->
                    if (dataDay.date == inputDay) {
                        AsyncImage(
                            modifier = Modifier
                                .size(88.dp)
                                .padding(top = 24.dp),
                            model = "https://${dataDay.day.condition.icon}",
                            contentDescription = "weather icon"
                        )
                        hourDetailsDataList.add(DetailsInfo(infoType = "Max temp", infoValue = "${dataDay.day.maxTempC} ºС"))
                        hourDetailsDataList.add(DetailsInfo(infoType = "Min temp", infoValue = "${dataDay.day.minTempC} ºС"))
                        hourDetailsDataList.add(DetailsInfo(infoType = "Max wind", infoValue = "${dataDay.day.maxWindKph} km/h"))
                        hourDetailsDataList.add(DetailsInfo(infoType = "UV index", infoValue = dataDay.day.uv.toString()))
                        hourDetailsDataList.add(DetailsInfo(infoType = "Sunrise", infoValue = dataDay.astro.sunrise))
                        hourDetailsDataList.add(DetailsInfo(infoType = "Sunset", infoValue = dataDay.astro.sunset))
                        hourDetailsDataList.add(DetailsInfo(infoType = "Will it rain", infoValue = if (dataDay.day.dailyWillItRain == 0) "No" else "Yes"))
                        hourDetailsDataList.add(DetailsInfo(infoType = "Will it snow", infoValue = if (dataDay.day.dailyWillItSnow == 0) "No" else "Yes"))
                    }
                }
                Text(text = data.location.name, fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color(0xC0000000))
                Text(text = inputDay.toString(), fontSize = 22.sp, color = Color(0xC0000000))

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
                                    text = hourDetailsDataList[index].infoType,
                                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp),
                                    color = Color(0x90000000)
                                )
                                Text(
                                    text = hourDetailsDataList[index].infoValue,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier.padding(top = 4.dp, bottom = 8.dp),
                                    color = Color(0x90000000)
                                )
                            }
                        }
                    }
                })
            }
        }
    }
}