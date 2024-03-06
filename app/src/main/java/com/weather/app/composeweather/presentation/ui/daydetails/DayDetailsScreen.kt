package com.weather.app.composeweather.presentation.ui.daydetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.weather.core.ui.theme.LightBlue

@Composable
fun DayDetailsScreen(
    onBackClick: () -> Unit
) {
    val statusBarHeight = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBlue)
            .padding(start = 8.dp, end = 8.dp, bottom = 8.dp, top = statusBarHeight)
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 4.dp),
            colors = CardDefaults.cardColors(Color(0x80F1FEFF)),
            elevation = CardDefaults.cardElevation(0.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column {
            }
        }
    }
}