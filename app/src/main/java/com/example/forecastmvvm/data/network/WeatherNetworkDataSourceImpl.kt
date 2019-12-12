package com.example.forecastmvvm.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.forecastmvvm.data.database.entity.CurrentWeatherEntry
import com.example.forecastmvvm.data.internal.NoConnectivityException
import com.example.forecastmvvm.data.network.response.CurrentWeatherResponse

class WeatherNetworkDataSourceImpl(
    private val apixuWeatherAPIService: ApixuWeatherAPIService
) : WeatherNetworkDataSource {
    private val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
    override val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downloadedCurrentWeather

    override suspend fun getCurrentWeather(location: String) {
        try {
            val currentWeather = apixuWeatherAPIService.getCurrentWeather(location)
            _downloadedCurrentWeather.postValue(currentWeather)
        } catch (e : NoConnectivityException) {
            Log.e("Connectivity", "No internet connection", e)
        }
    }
}