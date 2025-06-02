package com.assignment.weather.android.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.assignment.weather.android.viewmodel.WeatherViewModel

@Composable
fun WeatherScreen(viewModel: WeatherViewModel = hiltViewModel()) {
    val weather = viewModel.weather
    val isLoading = viewModel.isLoading
    val error = viewModel.errorMessage

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        when {
            isLoading -> CircularProgressIndicator()
            error != null -> Text("Error: $error")
            weather != null -> Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Temp: ${weather.temperature}°C")
                Text("Wind: ${weather.windspeed} km/h")
                Text("Time: ${weather.time}")
            }
        }
    }
}