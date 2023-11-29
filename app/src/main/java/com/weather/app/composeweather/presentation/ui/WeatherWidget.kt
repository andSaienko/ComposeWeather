package com.weather.app.composeweather.presentation.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.weather.app.composeweather.R
import com.weather.app.composeweather.data.model.response.HourDTO
import com.weather.app.composeweather.domain.model.WeatherResponseDTO
import com.weather.app.composeweather.presentation.ui.items.WeatherDayListItem
import com.weather.app.composeweather.presentation.ui.items.WeatherHourListItem
import com.weather.app.composeweather.presentation.viewmodel.WeatherViewModel
import kotlinx.coroutines.launch
import java.time.LocalTime

@SuppressLint("CoroutineCreationDuringComposition")


@Composable
fun WeatherWidget(viewModel: WeatherViewModel = viewModel(), data: WeatherResponseDTO) {
    var isDialogVisible by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Card(
            colors = CardDefaults.cardColors(Color(0x80F1FEFF)),
            elevation = CardDefaults.cardElevation(0.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = data.currentWeather?.lastUpdated.toString(),
                    fontSize = 16.sp,
                    color = Color(0x80000000),

                    )
                AsyncImage(
                    modifier = Modifier.size(24.dp), model = "https://${data.currentWeather?.condition?.icon}", contentDescription = "weather icon"
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = data.location?.name ?: "unknown", fontSize = 26.sp, color = Color(0xC0000000)
                )
                Text(
                    text = "${data.currentWeather?.tempC.toString()}ºC", fontSize = 48.sp, color = Color(0xC0000000)
                )
                Text(
                    text = data.currentWeather?.condition?.text.toString(), fontSize = 14.sp, color = Color(0x80000000)
                )
            }
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(onClick = { isDialogVisible = true }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search), contentDescription = "search button", tint = Color(0x80000000)
                    )
                }
                Text(
                    text = "Feels like ${data.currentWeather?.feelslikeC}ºС ", fontSize = 14.sp, color = Color(0x80000000)
                )
                IconButton(onClick = {
                    viewModel.viewModelScope.launch {
                        viewModel.getWeather(viewModel.loadActualCity())
                    }
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_refresh), contentDescription = "refresh button", tint = Color(0x80000000)
                    )
                }

                if (isDialogVisible) {
                    InputCityDialog(
                        onDismiss = { isDialogVisible = false },
                        onConfirm = { city ->
                            viewModel.getWeather(city)
                            viewModel.saveActualCity(city)
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HourDayTabLayout(data: WeatherResponseDTO) {
    val tabList = listOf("Hours", "Days")
    val pagerState = rememberPagerState()
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        TabRow(modifier = Modifier.clip(RoundedCornerShape(16.dp)),
            selectedTabIndex = tabIndex,
            indicator = { position ->
                TabRowDefaults.Indicator(
                    modifier = Modifier
                        .width(50.dp)
                        .tabIndicatorOffset(position[tabIndex]),
                    color = Color(0x80000000),
                    height = 2.dp
                )
            },
            containerColor = Color(0x80F1FEFF),
            divider = { Divider(color = Color.Transparent) }) {
            tabList.forEachIndexed { index, title ->
                Tab(selected = false, onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }) {
                    Text(
                        text = title, fontSize = 18.sp, modifier = Modifier.padding(8.dp), color = Color(0x80000000)
                    )
                }
            }
        }
        HorizontalPager(
            modifier = Modifier.padding(top = 8.dp),
            count = tabList.size,
            state = pagerState,
        ) { index ->
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                when (index) {
                    0 -> {
                        val hoursList = data.forecast?.forecastday?.get(index)?.hour

                        val currentHour = LocalTime.now().hour

                        val futureHoursList =
                            hoursList?.size?.let {
                                hoursList.subList(
                                    currentHour + 1,
                                    it
                                )
                            }

                        val independentList: ArrayList<HourDTO> = ArrayList(futureHoursList.orEmpty())

                        itemsIndexed(independentList) { _, item ->
                            WeatherHourListItem(item = item)
                        }
                    }

                    1 -> {
                        itemsIndexed(data.forecast?.forecastday ?: emptyList()) { _, item ->
                            WeatherDayListItem(item = item)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LottieAnim(data: WeatherResponseDTO? = null) {

    //Todo FOR FUTURE
//    val actualWeatherAnim: Int = when (data?.current?.condition?.text) {
//        "Blizzard" -> R.raw.snow_anim
//        else -> R.raw.sky_anim
//    }

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.sky_anim))
    val progress by animateLottieCompositionAsState(composition, iterations = LottieConstants.IterateForever)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF329BDC)),
    ) {
        LottieAnimation(composition = composition, progress = { progress })
    }
}
