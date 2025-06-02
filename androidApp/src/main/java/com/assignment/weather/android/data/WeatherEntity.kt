package com.assignment.weather.android.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather")
data class WeatherEntity(
    @PrimaryKey val time: String,
    val temperature: Double,
    val windspeed: Double,
    val winddirection: Double,
    val weathercode: Int
)