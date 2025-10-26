package com.example.shuttleapp.presentation.state

import com.example.shuttleapp.data.local.ShuttlePassWithPassengerEntity

data class ShuttlePassListState(
    val loading: Boolean = false,
    val list: List<ShuttlePassWithPassengerEntity> = emptyList(),
    val error: String? = null
)
