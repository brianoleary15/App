package com.briantoleary.weatherapp.data.network

import com.briantoleary.weatherapp.data.db.entity.CurrentWeather
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

// const val API_KEY = "73249b4e57d527507e8ee6397efe39ac"

//https://api.darksky.net/forecast/73249b4e57d527507e8ee6397efe39ac/40.948865,-74.000902

interface DarkSkiesWeatherApiService {

    @GET("{lat},{long}")
    fun getCurrentWeather(
        @Path("lat") latitude: Double,
        @Path("long") longitude: Double
    ): Deferred<CurrentWeather>

    companion object {
        operator fun invoke(
            connectivityInterceptor: ConnectivityInterceptor
        ): DarkSkiesWeatherApiService {
            val requestInterceptor = Interceptor {
                chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()
                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(connectivityInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.darksky.net/forecast/73249b4e57d527507e8ee6397efe39ac/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DarkSkiesWeatherApiService::class.java)
        }
    }
}