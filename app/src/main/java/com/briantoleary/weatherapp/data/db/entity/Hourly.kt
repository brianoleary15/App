package com.briantoleary.weatherapp.data.db.entity


data class Hourly(
    val `data`: List<DataX>,
    val icon: String,
    val summary: String
)