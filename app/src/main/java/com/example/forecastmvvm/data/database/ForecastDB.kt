package com.example.forecastmvvm.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.forecastmvvm.data.database.dao.CurrentWeatherDao

@Database(
    entities = [CurrentWeatherDao::class], version = 1)

abstract class ForecastDB : RoomDatabase() {
    abstract fun CurrentWeatherDao() : CurrentWeatherDao

    companion object {
        @Volatile private var instance : ForecastDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it;
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ForecastDB::class.java, "forecast_db")
                .build()
    }
}