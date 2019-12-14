package com.example.forecastmvvm.data

import androidx.lifecycle.LiveData
import com.example.forecastmvvm.data.database.entity.CurrentWeatherEntry

interface ForecastRepository {
    suspend fun getCurrentWeather() : LiveData<out CurrentWeatherEntry>
}