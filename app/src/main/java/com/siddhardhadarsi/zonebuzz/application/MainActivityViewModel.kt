package com.siddhardhadarsi.zonebuzz.application

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siddhardhadarsi.zonebuzz.domain.models.DarkThemeConfig
import com.siddhardhadarsi.zonebuzz.domain.models.ThemeBrand
import com.siddhardhadarsi.zonebuzz.domain.models.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    val uiState: MutableStateFlow<MainActivityUiState> =  MutableStateFlow(MainActivityUiState.Loading)

    init {
        emitDummyUserData()
    }

    fun emitDummyUserData(){
        viewModelScope.launch {
            kotlinx.coroutines.delay(1000)
            val themeBrand = ThemeBrand.DEFAULT
            val darkThemeConfig = DarkThemeConfig.DARK
            val useDynamicColor = false
            val shouldHideOnboarding = true

            uiState.emit(MainActivityUiState.Success(UserData(themeBrand, darkThemeConfig,useDynamicColor , shouldHideOnboarding)))
        }
    }
}

sealed interface MainActivityUiState {
    data object Loading : MainActivityUiState

    data class Success(val userData: UserData) : MainActivityUiState {
        override val shouldDisableDynamicTheming = !userData.useDynamicColor

        override val shouldUseAndroidTheme: Boolean = when (userData.themeBrand) {
            ThemeBrand.DEFAULT -> false
            ThemeBrand.ANDROID -> true
        }

        override fun shouldUseDarkTheme(isSystemDarkTheme: Boolean) =
            when (userData.darkThemeConfig) {
                DarkThemeConfig.FOLLOW_SYSTEM -> isSystemDarkTheme
                DarkThemeConfig.LIGHT -> false
                DarkThemeConfig.DARK -> true
            }
    }

    /**
     * Returns `true` if the state wasn't loaded yet and it should keep showing the splash screen.
     */
    fun shouldKeepSplashScreen() = this is Loading

    /**
     * Returns `true` if the dynamic color is disabled.
     */
    val shouldDisableDynamicTheming: Boolean get() = true

    /**
     * Returns `true` if the Android theme should be used.
     */
    val shouldUseAndroidTheme: Boolean get() = false

    /**
     * Returns `true` if dark theme should be used.
     */
    fun shouldUseDarkTheme(isSystemDarkTheme: Boolean) = isSystemDarkTheme
}