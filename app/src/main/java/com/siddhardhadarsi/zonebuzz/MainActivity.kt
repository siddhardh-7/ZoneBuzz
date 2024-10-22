package com.siddhardhadarsi.zonebuzz

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.siddhardhadarsi.zonebuzz.core.theme.ZoneBuzzTheme
import com.siddhardhadarsi.zonebuzz.navigation.AppNavHost

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