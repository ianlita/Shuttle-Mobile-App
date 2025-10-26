package com.example.shuttleapp.presentation.state

import com.example.shuttleapp.domain.model.ShuttleProvider

data class ShuttleProviderState(
    val isLoading: Boolean = false,
    val list: List<ShuttleProvider> = emptyList(),
    val error: String? = null
)