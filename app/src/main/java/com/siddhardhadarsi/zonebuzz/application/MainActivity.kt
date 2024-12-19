package com.siddhardhadarsi.zonebuzz.application

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.siddhardhadarsi.zonebuzz.application.theme.ZoneBuzzTheme
import com.siddhardhadarsi.zonebuzz.core.navigation.AppNavHost

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZoneBuzzTheme {
                AppNavHost()
            }
        }
    }
}