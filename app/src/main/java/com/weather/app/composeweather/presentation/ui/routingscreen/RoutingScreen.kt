package com.weather.app.composeweather.presentation.ui.routingscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.weather.app.composeweather.R
import com.weather.app.composeweather.presentation.state.ViewState
import com.weather.core.ui.theme.LightBlue

@Composable
fun RoutingWidget(state: ViewState) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBlue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when (state) {
            is ViewState.RoutingState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.size(120.dp), color = Color(0x80F1FEFF)
                )
            }

            is ViewState.RoutingState.Error -> {
                Image(
                    modifier = Modifier.size(120.dp), painter = painterResource(id = R.drawable.ic_error), contentDescription = "error icon"
                )
                Text(
                    text = "Wrong country", fontSize = 32.sp, fontWeight = FontWeight.SemiBold, color = Color.White
                )
            }

            else -> Unit
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RoutingPreview() {
    RoutingWidget(state = ViewState.RoutingState.Error)
}