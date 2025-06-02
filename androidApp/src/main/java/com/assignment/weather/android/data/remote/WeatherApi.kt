package com.assignment.weather.android.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("v1/forecast")
    suspend fun getCurrentWeather(@Query("latitude") latitude: Double, @Query("longitude") longitude: Double, @Query("current_weather") currentWeather: Boolean = true
    ): WeatherResponse
}