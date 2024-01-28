package com.weather.app.composeweather.presentation.compose.routingscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.weather.app.composeweather.R
import com.weather.app.composeweather.presentation.state.ViewState

@Composable
fun RoutingTheme(state: ViewState) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF329BDC)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when (state) {
            is ViewState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(120.dp),
                    color = Color(0x80F1FEFF)
                )
            }

            is ViewState.Error -> {
                Image(
                    modifier = Modifier
                        .size(120.dp),
                    painter = painterResource(id = R.drawable.ic_error),
                    contentDescription = "error icon"
                )
            }

            else -> Unit
        }
    }
}