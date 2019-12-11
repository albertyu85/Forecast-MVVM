package com.example.forecastmvvm.ui.weather.current

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.forecastmvvm.R
import com.example.forecastmvvm.data.ApixuWeatherAPIService
import kotlinx.android.synthetic.main.current_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class CurrentFragment : Fragment() {

    companion object {
        fun newInstance() = CurrentFragment()
    }

    private lateinit var viewModel: CurrentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CurrentViewModel::class.java)
        // TODO: Use the
        val apiService = ApixuWeatherAPIService()

        GlobalScope.launch(Dispatchers.Main){
            val currentWeatherResponse = apiService.getCurrentWeather("San Jose")
            current_text_view.text = currentWeatherResponse.currentWeatherEntry.toString();
        }
    }

}
