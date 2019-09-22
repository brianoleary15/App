package com.briantoleary.weatherapp.data.network.response

import com.briantoleary.weatherapp.data.db.entity.*
import com.google.gson.annotations.SerializedName


data class WeatherForecastResponse(
    @SerializedName("currently")
    val currentWeather: CurrentWeather,
    val daily: Daily,
    val flags: Flags,
    val hourly: Hourly,
    val latitude: Double,
    val longitude: Double,
    val minutely: Minutely,
    val offset: Int,
    val timezone: String
)