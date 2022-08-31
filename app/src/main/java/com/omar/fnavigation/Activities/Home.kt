package com.omar.fnavigation.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.omar.fnavigation.R
import com.omar.fnavigation.Activities.Home
import com.omar.fnavigation.UI.quran.QuranFragment
import com.omar.fnavigation.UI.tasbeh.TasbehFragment

lateinit var bottomNavigation : BottomNavigationView

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNavigation = findViewById(R.id.bottom_navigation)

        bottomNavigation.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener {
            menuItem ->

            if(menuItem.itemId == R.id.quran_navigation){
                pushFragment(QuranFragment())
            }
            else if (menuItem.itemId == R.id.hadeth_navigation){
                pushFragment(HadethFragment())
            }
            else if (menuItem.itemId == R.id.tasbeh_navigation){
                pushFragment(TasbehFragment())
            }
            else if (menuItem.itemId == R.id.radio_navigation){
                pushFragment(RadioFragment())
            }
            return@OnItemSelectedListener true
        })


        }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
    }
}

