package com.omar.islamicfproject.presentation.views.activities.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.omar.islamicfproject.R

class HomeAct : AppCompatActivity() {


    private lateinit var toolbar        : MaterialToolbar
    private lateinit var navController  : NavController
    private lateinit var bottomNavView  : BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)

        toolbar = findViewById(R.id.activity_main_toolbar)
        // Initialize Views
        bottomNavView         = findViewById(R.id.bottom_nav_view)

        // GetNavHostFragment and NavController
        val navHostFrag = supportFragmentManager.findFragmentById(R.id.nav_host_frag) as NavHostFragment?
        navController   = navHostFrag?.navController!!

        // Define AppBarConfiguration
        val topLevelDestination  = setOf(R.id.hadethFragment, R.id.quranFragment, R.id.sebhaFragment, R.id.radioFragment)
        val appBarConfiguration  = AppBarConfiguration(topLevelDestination)

        // Connect Toolbar with NavController
        toolbar.setupWithNavController(navController, appBarConfiguration)

        // Connect BottomNavigationView with NavController
        bottomNavView.setupWithNavController(navController)
    }


}