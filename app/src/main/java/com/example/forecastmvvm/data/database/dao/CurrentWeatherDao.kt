package com.example.forecastmvvm.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.forecastmvvm.data.database.entity.CURRENT_WEATHER_ID
import com.example.forecastmvvm.data.database.entity.CurrentWeatherEntry
import com.example.forecastmvvm.data.database.unitlocalized.BriefCurrentWeatherEntry
import com.example.forecastmvvm.data.database.unitlocalized.DetailedCurrentWeatherEntry

@Dao
interface CurrentWeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(currentWeatherEntry: CurrentWeatherEntry)

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getBrief() : LiveData<BriefCurrentWeatherEntry>

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getDetailed() : LiveData<DetailedCurrentWeatherEntry>

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getAll() : LiveData<CurrentWeatherEntry>
}