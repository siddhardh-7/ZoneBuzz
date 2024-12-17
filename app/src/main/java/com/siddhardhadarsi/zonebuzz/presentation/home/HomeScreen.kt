package com.siddhardhadarsi.zonebuzz.presentation.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.siddhardhadarsi.zonebuzz.core.constants.TagUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(title = {
            Text(
                TagUtils.AppName,
            )
        }, navigationIcon = {}, actions = {
            IconButton(onClick = { }) {
                Icon(Icons.Default.Settings, contentDescription = "Settings")
            }
        })
    }, floatingActionButton = {
        FloatingActionButton(
            onClick = {},
        ) {
            Icon(Icons.Filled.Add, "Add Alarm")
        }
    }, modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        HomeScreenContent(innerPadding)
    }
}

@Composable
fun HomeScreenContent(innerPadding: PaddingValues = PaddingValues()) {
    Text(
        "Home Screen Content", textAlign = TextAlign.Center, modifier = Modifier.fillMaxSize()
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}