package com.briantoleary.weatherapp.data.db.entity


data class Minutely(
    val `data`: List<DataXX>,
    val icon: String,
    val summary: String
)