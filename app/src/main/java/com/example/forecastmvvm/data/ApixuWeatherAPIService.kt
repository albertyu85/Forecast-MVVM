package com.example.forecastmvvm.data

import com.example.forecastmvvm.data.database.network.response.CurrentWeatherResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "37ef2bf01405280ffcb8d45315edd934"
interface ApixuWeatherAPIService {
//http://api.weatherstack.com/current
//    ? access_key = YOUR_ACCESS_KEY
//    & query = New York

    @GET("current")
    suspend fun getCurrentWeather(@Query("query") location: String,
                                  @Query("access_key") key: String = API_KEY,
                                  @Query("units") unit: String = "f"): CurrentWeatherResponse

    companion object {
        operator fun invoke(): ApixuWeatherAPIService {

            return Retrofit.Builder()
                .baseUrl("http://api.weatherstack.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApixuWeatherAPIService::class.java)
        }
    }
}