package com.example.forecastmvvm.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.forecastmvvm.data.database.ForecastDB
import com.example.forecastmvvm.data.database.dao.CurrentWeatherDao
import com.example.forecastmvvm.data.database.entity.CurrentWeatherEntry
import com.example.forecastmvvm.data.network.WeatherNetworkDataSource
import com.example.forecastmvvm.data.network.response.CurrentWeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.ZonedDateTime

class ForecastRepositoryImpl(
    private val weatherNetworkDataSource: WeatherNetworkDataSource,
    private val currentWeatherDao: CurrentWeatherDao
) : ForecastRepository {
    init{
        weatherNetworkDataSource.downloadedCurrentWeather.observeForever {
            persistFetchedData(it)
        }
    }
    override suspend fun getCurrentWeather() : LiveData<out CurrentWeatherEntry> {
        initWeatherData()
        return withContext(Dispatchers.IO) {
            return@withContext currentWeatherDao.getAll()
        }
    }

    private fun isFetchCurrentNeeded(lastFetchTime: ZonedDateTime) : Boolean {
        val thirtyMinutesAgo = ZonedDateTime.now().minusMinutes(30)
        return lastFetchTime.isBefore(thirtyMinutesAgo)
    }

    private suspend fun initWeatherData() {
        if (isFetchCurrentNeeded(ZonedDateTime.now().minusHours(1)))
            fetchCurrentWeather()
    }

    private suspend fun fetchCurrentWeather() {
        weatherNetworkDataSource.getCurrentWeather("San Jose")
    }

    private fun persistFetchedData(currentWeatherResponse: CurrentWeatherResponse) {
        GlobalScope.launch(Dispatchers.IO) {
            currentWeatherDao.upsert(currentWeatherResponse.currentWeatherEntry)
        }
    }
}