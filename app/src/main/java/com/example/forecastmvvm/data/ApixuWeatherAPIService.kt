package com.example.forecastmvvm.data

import com.example.forecastmvvm.data.response.CurrentWeatherResponse
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
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
    suspend fun getCurrentWeather(@Query("query") location: String): CurrentWeatherResponse

    companion object {
        operator fun invoke(): ApixuWeatherAPIService {

            val requestInterceptor = Interceptor {
                val url = it.request()
                    .newBuilder()
                    .addHeader("access_key", API_KEY)
                    .build()
                val request = it.request()
                    .newBuilder()
                    .url(url.toString())
                    .build()

                return@Interceptor it.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()
            return Retrofit.Builder()
                .baseUrl("http://api.weatherstack.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApixuWeatherAPIService::class.java)
        }
    }
}