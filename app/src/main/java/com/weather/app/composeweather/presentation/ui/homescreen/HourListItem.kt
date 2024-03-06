package com.weather.app.composeweather.presentation.ui.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.weather.app.composeweather.data.model.response.HourDTO
import kotlin.math.floor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherHourListItem(
    item: HourDTO,
    onHourItemClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(Color(0x80F1FEFF)),
        elevation = CardDefaults.cardElevation(0.dp),
        shape = RoundedCornerShape(16.dp),
        onClick = onHourItemClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(0.45f)
            ) {
                Text(
                    text = item.time, color = Color(0x80000000), fontSize = 14.sp
                )
                Text(
                    text = item.condition.text, color = Color(0x80000000), fontSize = 14.sp
                )
            }
            Text(
                modifier = Modifier.weight(1f), text = "${floor(item.tempC).toInt()}ºС", color = Color(0x80000000), fontSize = 24.sp
            )
            AsyncImage(
                modifier = Modifier.size(24.dp), model = "https:${item.condition.icon}", contentDescription = "weather icon"
            )
        }
    }
}