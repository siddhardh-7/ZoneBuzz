package com.siddhardhadarsi.zonebuzz.presentation.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun HomeScreen() {
    Text(
        "Home Screen",
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxSize().systemBarsPadding()
    )
}