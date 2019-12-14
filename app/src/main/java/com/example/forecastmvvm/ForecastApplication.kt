package com.example.forecastmvvm

import android.app.Application
import com.example.forecastmvvm.data.ForecastRepository
import com.example.forecastmvvm.data.ForecastRepositoryImpl
import com.example.forecastmvvm.data.database.ForecastDB
import com.example.forecastmvvm.data.network.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class ForecastApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@ForecastApplication))

        bind() from singleton { ForecastDB(instance()) }
        bind() from singleton {instance<ForecastDB>().CurrentWeatherDao()}
        bind<ConnectivityInterceptor>() with singleton {ConnectivityInterceptorImpl(instance())}
        bind() from singleton {ApixuWeatherAPIService(instance())}
        bind<WeatherNetworkDataSource>() with singleton {WeatherNetworkDataSourceImpl(instance())}
        bind<ForecastRepository>() with singleton {ForecastRepositoryImpl(instance(), instance()) }
    }

}