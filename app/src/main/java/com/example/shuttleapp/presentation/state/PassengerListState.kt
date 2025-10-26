package com.example.shuttleapp.presentation.state

import com.example.shuttleapp.data.local.PassengerQREntity

data class PassengerListState(
    val loading: Boolean = false,
    val list: List<PassengerQREntity> = emptyList(),
    val error: String? = null
)
