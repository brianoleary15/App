package com.briantoleary.weatherapp.data.db.entity


import com.google.gson.annotations.SerializedName

data class DataX(
    val apparentTemperature: Double,
    val cloudCover: Int,
    val dewPoint: Double,
    val humidity: Double,
    val icon: String,
    val ozone: Double,
    val precipIntensity: Int,
    val precipProbability: Int,
    val precipType: String,
    val pressure: Double,
    val summary: String,
    val temperature: Double,
    val time: Int,
    val uvIndex: Int,
    val visibility: Int,
    val windBearing: Int,
    val windGust: Double,
    val windSpeed: Double
)