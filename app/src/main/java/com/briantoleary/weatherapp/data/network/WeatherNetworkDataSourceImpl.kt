package com.briantoleary.weatherapp.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.briantoleary.weatherapp.data.db.entity.CurrentWeather
import com.briantoleary.weatherapp.internal.NoConnectivityException
import android.util.Log

class WeatherNetworkDataSourceImpl(
    private val darkSkiesWeatherApiService: DarkSkiesWeatherApiService)
    : WeatherNetworkDataSource {

    private val _downloadCurrentWeather = MutableLiveData<CurrentWeather>()

    override val downloadCurrentWeather: LiveData<CurrentWeather>
        get() = _downloadCurrentWeather

    override suspend fun fetchCurrentWeather(latitude: Double, longitude: Double) {
        try {
            val fetchedCurrentWeather = darkSkiesWeatherApiService
                .getCurrentWeather(latitude, longitude)
                .await()
            _downloadCurrentWeather.postValue(fetchedCurrentWeather)
        }
        catch( e: NoConnectivityException) {
            Log.e("Connectivity", "No internet connectivity.", e)
        }
    }
}