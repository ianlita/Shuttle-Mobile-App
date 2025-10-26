package com.example.shuttleapp.presentation.state

import com.example.shuttleapp.data.local.ShuttlePassWithPassengerEntity

data class ShuttlePassWithPassengerState(
    val isLoading: Boolean = false,
    val data: ShuttlePassWithPassengerEntity? = null,
    val error: String? = null
)