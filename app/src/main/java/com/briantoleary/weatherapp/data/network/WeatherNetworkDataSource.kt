package com.briantoleary.weatherapp.data.network

import androidx.lifecycle.LiveData
import com.briantoleary.weatherapp.data.db.entity.CurrentWeather

interface WeatherNetworkDataSource {
    val downloadCurrentWeather: LiveData<CurrentWeather>

    suspend fun fetchCurrentWeather(latitude: Double, longitude: Double)
}