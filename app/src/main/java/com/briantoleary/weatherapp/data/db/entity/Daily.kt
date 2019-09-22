package com.briantoleary.weatherapp.data.db.entity

import androidx.room.Embedded
import androidx.room.Entity

@Entity(tableName = "daily_weather")
data class Daily(
    @Embedded(prefix = "daily_")
    val `data`: List<Data>,
    val icon: String,
    val summary: String
)