package com.example.forecastmvvm.data.database.unitlocalized

import androidx.room.ColumnInfo

class BriefCurrentWeatherEntry(
    @ColumnInfo(name = "observation_time")
    val observationTime: String,
    @ColumnInfo(name = "temperature")
    val temperature: Int,
    @ColumnInfo(name = "wind_speed")
    val windspeed: Int
)