package com.example.forecastmvvm.data.database.unitlocalized

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

class DetailedCurrentWeatherEntry(
    @ColumnInfo(name = "cloudcover")
    val cloudcover: Int,
    @ColumnInfo(name = "feelslike")
    val feelslike: Int,
    @ColumnInfo(name = "humidity")
    val humidity: Int,
    @ColumnInfo(name = "observation_time")
    val observationTime: String,
    @ColumnInfo(name = "precip")
    val precip: Int,
    @ColumnInfo(name = "pressure")
    val pressure: Int,
    @ColumnInfo(name = "temperature")
    val temperature: Int,
    @ColumnInfo(name = "uv_index")
    val uvIndex: Int,
    @ColumnInfo(name = "visibility")
    val visibility: Int,
    @ColumnInfo(name = "weather_code")
    val weatherCode: Int,
    @ColumnInfo(name = "wind_degree")
    val windDegree: Int,
    @ColumnInfo(name = "wind_dir")
    val windDir: String,
    @ColumnInfo(name = "wind_speed")
    val windSpeed: Int
)