package com.example.shuttleapp.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.ActivityNavigator

@Composable
fun NavDestinationHelper(
    shouldNavigate: () -> Boolean,
    destination: () -> Unit
) {
    LaunchedEffect(shouldNavigate()) {
        if(shouldNavigate()) {
            destination()
        }
    }

}