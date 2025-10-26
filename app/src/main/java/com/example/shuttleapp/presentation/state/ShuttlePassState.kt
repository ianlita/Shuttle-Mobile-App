package com.example.shuttleapp.presentation.state

import com.example.shuttleapp.data.local.ShuttlePassEntity

data class ShuttlePassState(
    val isLoading: Boolean = false,
    val data: ShuttlePassEntity? = null,
    val error: String? = null
)
