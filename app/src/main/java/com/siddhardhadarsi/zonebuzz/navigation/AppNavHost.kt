package com.siddhardhadarsi.zonebuzz.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.siddhardhadarsi.zonebuzz.presentation.home.HomeScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.HOME.name,
    ){
        composable(Screen.HOME.name){
            HomeScreen()
        }
    }
}