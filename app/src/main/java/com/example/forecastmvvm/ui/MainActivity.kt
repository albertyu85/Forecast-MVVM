package com.example.forecastmvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.forecastmvvm.ui.weather.future.list.FutureListFragment
import com.example.forecastmvvm.R
import com.example.forecastmvvm.ui.settings.SettingsFragment
import com.example.forecastmvvm.ui.weather.current.CurrentFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    var fragmentManager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        var bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_nav)

        showToday()
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.today -> {
                    showToday()
                    true
                }
                R.id.future -> {
                    showFuture()
                    true
                }
                R.id.settings -> {
                    showSettings()
                    true
                }
                else -> false

            }
        }
    }

    private fun showToday() {
        fragmentManager.beginTransaction().replace(
            R.id.frame_layout,
            CurrentFragment(), "today").commit()
    }
    private fun showFuture() {
        fragmentManager.beginTransaction().replace(
            R.id.frame_layout,
            FutureListFragment(), "future").addToBackStack(null).commit()
    }
    private fun showSettings() {
        fragmentManager.beginTransaction().replace(
            R.id.frame_layout,
            SettingsFragment(), "settings").addToBackStack(null).commit()
    }
}
