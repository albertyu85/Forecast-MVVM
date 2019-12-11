package com.example.forecastmvvm.data.database.entity


import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

const val CURRENT_WEATHER_ID = 0

@Entity(tableName="current_weather")
data class CurrentWeatherEntry(
    @PrimaryKey(autoGenerate = false)
    var id: Int = CURRENT_WEATHER_ID,
    val cloudcover: Int,
    val feelslike: Int,
    val humidity: Int,
    @SerializedName("observation_time")
    val observationTime: String,
    val precip: Int,
    val pressure: Int,
    val temperature: Int,
    @SerializedName("uv_index")
    val uvIndex: Int,
    val visibility: Int,
    @SerializedName("weather_code")
    val weatherCode: Int,
    @Ignore
    @SerializedName("weather_descriptions")
    val weatherDescriptions: List<String>,
    @Ignore
    @SerializedName("weather_icons")
    val weatherIcons: List<String>,
    @SerializedName("wind_degree")
    val windDegree: Int,
    @SerializedName("wind_dir")
    val windDir: String,
    @SerializedName("wind_speed")
    val windSpeed: Int
)