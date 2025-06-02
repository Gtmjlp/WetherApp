package com.assignment.weather.android.data.repository

import com.assignment.weather.android.data.WeatherDao
import com.assignment.weather.android.data.WeatherEntity
import com.assignment.weather.android.data.remote.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val api: WeatherApi,
    private val dao: WeatherDao
) {
    suspend fun getWeather(lat: Double, lon: Double): WeatherEntity {
        return try {
            val remote = api.getCurrentWeather(lat, lon).currentWeather
            val entity = WeatherEntity(
                time = remote.time,
                temperature = remote.temperature,
                windspeed = remote.windspeed,
                winddirection = remote.winddirection,
                weathercode = remote.weathercode
            )
            dao.insertWeather(entity)
            entity
        } catch (e: Exception) {
            dao.getLatestWeather() ?: throw e
        }
    }
}
