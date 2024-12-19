package com.siddhardhadarsi.zonebuzz.core.navigation

enum class Screen {
    HOME
}
sealed class NavigationItem(val route: String) {
    data object Home : NavigationItem(Screen.HOME.name)
}