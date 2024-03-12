package com.weather.app.composeweather.presentation.ui.daydetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
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
import com.weather.app.composeweather.presentation.state.ViewState
import com.weather.app.composeweather.presentation.viewmodel.HomeViewModel
import com.weather.core.ui.theme.LightBlue
import org.koin.androidx.compose.getViewModel

@Composable
fun DayDetailsScreen(
    viewModel: HomeViewModel = getViewModel(),
    inputDay: String?
) {
    val statusBarHeight = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
    val navBarHeight = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()

    val state by viewModel.state.collectAsState()
    val data = (state as ViewState.DataCollected).data

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBlue)
            .padding(start = 8.dp, end = 8.dp, bottom = navBarHeight + 8.dp, top = statusBarHeight)
    ) {
        Card(
            modifier = Modifier.fillMaxSize(),
            colors = CardDefaults.cardColors(Color(0x80F1FEFF)),
            elevation = CardDefaults.cardElevation(0.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column {
                Text(text = data.location.name)
            }
        }
    }
}