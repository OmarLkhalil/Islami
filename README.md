# IslamiProject

Islami is a first project at Route it has ( quran - hadeth - tasbeh - radio ).

## Clone

You can use the link from green button called code.
or you can just download it from here:

```bash
https://github.com/OmarLkhalil/RouteIslamiProject/archive/refs/heads/master.zip
```

## Project Description

 - It's a simple islamic application with simple 5 screens and navigation
 - Used (Fragments - Navigation - XML - Kotlin - resources - assets - splash)
 - Screen shots:
 

## 6 steps to make this simple project: 
  - First step:
 
     start with importing our drawable files  
     1 - Splash Screen - 2 - background 3- icons 
  - Second step: 
    
1-  make our splash screen Activity and start with 
     layout and set background to the splashscreen res 
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout 
xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/splash"
    tools:context=".Activities.splash">
</androidx.constraintlayout.widget.ConstraintLayout>
```
   
   2- make the kotlin code in splashescreen Activity file:
    
```kotlin
package com.omar.fnavigation.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper


class splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
 // we use Handler with this constructor (Looper.getMainLooper()) 
 // because the old Handler has been deprecated
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, Home::class.java))
            finish()
        }, 3000) // we set splash delay to 3 seconds then navigate to Home Screen
    }
}
```
3- now we make our AndroidManiFest.xml file and set IntentFiler to splash screen
 
```xml
       <activity
            android:name=".Activities.splash"
            android:exported="true"
            >
        <intent-filter>
            <action android:name="android.intent.action.MAIN" />

            <category android:name="android.intent.category.LAUNCHER" />
        </intent-filter>
        </activity>
```

Third step: 

- is to make our home Activity 

1 - start with layout 
  
```xml
       <?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout 
xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/bg3"
    tools:context=".Activities.Home">


    <FrameLayout
        android:id="@+id/fragment_container"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toTopOf="@id/bottom_navigation"
        app:layout_constraintEnd_toEndOf="parent"
        >

    </FrameLayout>

    <com.google.android.material.bottomnavigation.BottomNavigationView
        android:id="@+id/bottom_navigation"
        android:background="@color/gold"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintEnd_toEndOf="parent"
        app:menu="@menu/home_navigation" // the item menu is made there in res folder 
        app:itemTextColor="@color/bottom_navigation_icon_color"
        app:itemIconTint="@color/bottom_navigation_icon_color"
        />

</androidx.constraintlayout.widget.ConstraintLayout>
```

2- home.kt
```kotlin


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


```

