package com.assignment.weather.android.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.weather.android.data.WeatherEntity
import com.assignment.weather.android.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    var weather by mutableStateOf<WeatherEntity?>(null)
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    init {
        loadWeather()
    }

    fun loadWeather() {
        viewModelScope.launch {
            isLoading = true
            try {
                weather = repository.getWeather(40.71, -74.01)
            } catch (e: Exception) {
                errorMessage = e.localizedMessage
            }
            isLoading = false
        }
    }
}
