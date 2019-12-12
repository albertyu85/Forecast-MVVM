package com.example.forecastmvvm.data.network.response

import com.example.forecastmvvm.data.database.entity.CurrentWeatherEntry
import com.example.forecastmvvm.data.database.entity.Location
import com.example.forecastmvvm.data.database.entity.Request
import com.google.gson.annotations.SerializedName


data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location,
    val request: Request
)