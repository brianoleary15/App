package com.briantoleary.weatherapp.ui.current

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.briantoleary.weatherapp.R
import com.briantoleary.weatherapp.data.network.ConnectivityInterceptorImpl
import com.briantoleary.weatherapp.data.network.DarkSkiesWeatherApiService
import com.briantoleary.weatherapp.data.network.WeatherNetworkDataSourceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrentFragment : Fragment() {

    private lateinit var dashboardViewModel: CurrentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(CurrentViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_current, container, false)
        val textView: TextView = root.findViewById(R.id.text_current)
        dashboardViewModel.text.observe(this, Observer {
            val apiService = DarkSkiesWeatherApiService(ConnectivityInterceptorImpl(this.context!!))
            val weatherNetworkDataSource = WeatherNetworkDataSourceImpl(apiService)

            weatherNetworkDataSource.downloadCurrentWeather.observe(this, Observer {
                // Log.v("tag", it.temperature.toString())
                textView.text = it.toString()
            })
            GlobalScope.launch(Dispatchers.Main) {
                weatherNetworkDataSource.fetchCurrentWeather( 40.948865, -74.000902)

            }

        })
        return root
    }
}