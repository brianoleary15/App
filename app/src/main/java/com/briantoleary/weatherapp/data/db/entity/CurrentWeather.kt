package com.briantoleary.weatherapp.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

import com.google.gson.annotations.SerializedName

const val CURRENT_WEATHER_ID = 0
@Entity(tableName = "current_weather")
data class CurrentWeather(
    val apparentTemperature: Double,
    val cloudCover: Double,
    val dewPoint: Double,
    val humidity: Double,
    val icon: String,
    val nearestStormDistance: Int,
    val ozone: Double,
    val precipIntensity: Int,
    val precipProbability: Int,
    val pressure: Double,
    val summary: String,
    val temperature: Double,
    val time: Int,
    val uvIndex: Int,
    val visibility: Int,
    val windBearing: Int,
    val windGust: Double,
    val windSpeed: Double
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = CURRENT_WEATHER_ID
}